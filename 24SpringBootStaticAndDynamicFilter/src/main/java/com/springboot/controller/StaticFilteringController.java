package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.StaticFilter;
@RestController
public class StaticFilteringController {
	
	@GetMapping("/filtering")
	public StaticFilter retrieveSome() {
		return new StaticFilter("value1","value2","value3");
	}
	
	@GetMapping("/filtering-list")
	public List<StaticFilter> retrieveSomeList() {
		List<StaticFilter> someBeanList = new ArrayList<StaticFilter>();
		someBeanList.add(new StaticFilter("value1","value2","value3"));
		someBeanList.add(new StaticFilter("value11","value22","value3"));
		someBeanList.add(new StaticFilter("value21","value2","value33"));
		someBeanList.add(new StaticFilter("value41","value2","value3"));
		return someBeanList;
	}
}
