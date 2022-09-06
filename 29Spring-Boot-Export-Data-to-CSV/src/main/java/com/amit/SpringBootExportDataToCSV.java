package com.amit;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.amit.model.Person;
import com.amit.service.PersonService;

@SpringBootApplication
public class SpringBootExportDataToCSV {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootExportDataToCSV.class, args);
		PersonService personService = context.getBean(PersonService.class);

		// List<Person> personList = personService.listAll();
		// personList.forEach(per->System.out.println(per));
		// personService.exportToCSV(personList);
		List<Person> listObjArray = personService.getTotalEmployeeDetails();
		personService.exportToCSVObjectArray(listObjArray);
		//System.out.println(listObjArray);
		
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+listObjArray);
		System.out.println("SpringBootExportDataToCSV started successfully!---");
	}
}