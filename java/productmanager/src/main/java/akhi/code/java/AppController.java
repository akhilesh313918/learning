package akhi.code.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model){
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		return "index";
	}
	

	@RequestMapping("/new")
	public String showNewProductForm(Model model){
		Product product = new Product();
		model.addAttribute("product" , product);
		return "new_product";
	}
	
//	@RequestMapping(value="/save" , method = RequestMethod.POST)
//	public String saveProduct(@ModelAttribute("product") Product product) {
//		service.save(product);
//		
//		return "redirect:/";
//	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id){
		ModelAndView mav = new ModelAndView("edit_product"); 
		Product product = service.get(id);
		mav.addObject("product",product);
		return mav;
	}
	
//	@RequestMapping("/delete/{id}")
//	public String deleteProduct(@PathVariable(name = "id") Long id) {
//		 service.delete(id);
//		 return "redirect:/"; 
//	}
	
	@GetMapping("/products")
	@ResponseBody
	public List<Product> getProducts(Model model){
		List<Product> listProducts = service.listAll();
		return listProducts;
	}
	
	@GetMapping("/product/{id}")
	@ResponseBody
	public Product getProduct(@PathVariable("id") Long id){
		
		return service.get(id);
	}
	
	@PostMapping("/products")
	@ResponseBody
	public Product addProduct(@RequestBody Product product) {
		service.save(product);
		return product;
	}
	
	@PutMapping("/update/{id}")
	@ResponseBody
	public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
		product.setId(id);
		service.save(product);
		return product;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") Long id, Product product) {
		try {
			System.out.println("Inside delete");
			product.setId(id);
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
}
