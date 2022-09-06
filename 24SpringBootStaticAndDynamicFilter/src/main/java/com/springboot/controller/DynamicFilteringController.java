package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.springboot.bean.DynamicFilterBean;

@RestController
public class DynamicFilteringController {
	
	@GetMapping("/dyna-filtering")
	public MappingJacksonValue retrieveSomeBean() {
		DynamicFilterBean dynamicFilterBean = new DynamicFilterBean("value1", "value2", "value3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("Somebean", filter);
		MappingJacksonValue mapping  = new MappingJacksonValue(dynamicFilterBean);
		mapping.setFilters(filterProvider);
		
		return mapping;
	}

	@GetMapping("/dyna-filtering-list")
	public MappingJacksonValue retrieveSomeList() {
		List<DynamicFilterBean> dynamicBeanList = new ArrayList<DynamicFilterBean>();
		dynamicBeanList.add(new DynamicFilterBean("value1", "value2", "value3"));
		dynamicBeanList.add(new DynamicFilterBean("value11", "value22", "value3"));
		dynamicBeanList.add(new DynamicFilterBean("value21", "value2", "value33"));
		dynamicBeanList.add(new DynamicFilterBean("value41", "value2", "value3"));

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("Somebean", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(dynamicBeanList);
		mapping.setFilters(filterProvider);

		return mapping;
	}
}
