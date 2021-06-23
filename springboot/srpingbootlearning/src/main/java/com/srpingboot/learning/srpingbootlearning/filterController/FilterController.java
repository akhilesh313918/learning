package com.srpingboot.learning.srpingbootlearning.filterController;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {

	@GetMapping("/filter")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("field1", "field2", "field3");
	}
	
	@GetMapping("/filter-list")
	public List<SomeBean> retrieveListOfSomeBean(){
		List<SomeBean> list = Arrays.asList(new SomeBean(
				"field1", "field2", "field3"),
				new SomeBean("field1", "field2", "field3"));
		return list;
	}
	
	@GetMapping("/filter-using-setFilter")
	public MappingJacksonValue retrieveSomeNewBean() {
		
		SomeNewBean somenewbean = new SomeNewBean("field1", "field2", "field3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeNewBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(somenewbean);
		
		mapping.setFilters(filters);
		
		return mapping;
		
	}
	
}
