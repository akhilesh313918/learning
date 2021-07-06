package com.cmos.invoice.invoiceapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmos.invoice.invoiceapi.bean.Invoice;
import com.cmos.invoice.invoiceapi.repo.InvoiceItemRepository;
import com.cmos.invoice.invoiceapi.repo.InvoiceRepository;

@RestController
@RequestMapping("/api")
public class InvoiceController {
	
	
	@Autowired
	private InvoiceRepository invoiceRepo;
	private InvoiceItemRepository invoiceItemRepo;
	
	@GetMapping("/invoices")
	public List<Invoice> getAllInvoice(){
		return invoiceRepo.findAll();
	}
	
	@GetMapping("/invoice/{id}")
	public Optional<Invoice> getInvoiceDetails(@PathVariable long id) {
		return invoiceRepo.findById(id);
		
	}
	
	@PostMapping("/invoice/save")
	public Invoice saveInvoice(@RequestBody Invoice invoice){
		invoiceRepo.save(invoice);
		return invoice;
	}
}
