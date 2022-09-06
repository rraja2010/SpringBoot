package com.amit.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.amit.model.Person;
import com.amit.repo.UserRepository;
import com.amit.rowmapper.PersonRowMapper;

@Service
public class PersonService {
	
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;



	public List<Person> getTotalEmployeeDetails() {
		String selectQuery = "select username as User_name,first_name as First,last_name as Last from user_details";
		List<Person> list=jdbcTemplate.query(selectQuery, new PersonRowMapper());
		return list;
	}
	
	
	
	@Autowired
	private UserRepository repo;
	public List<Person> listAll() {
		return repo.findAll();
	}
	
	 public void exportToCSV(List<Person> perList) throws IOException {
	 
	        ICsvBeanWriter csvWriter = new CsvBeanWriter(new FileWriter("D:\\Person-Details.csv"), CsvPreference.STANDARD_PREFERENCE);
	        //user_id=1, username=rogers63, first_name=david, last_name=john, gender=Female, 
	        //password=e6a33eee180b07e563d74fee8c2c66b8, status=1
	        
	        String[] csvHeader = {"user_id", "username", "first_name", "last_name", "gender","password","status"};
	        String[] nameMapping = {"user_id", "username", "first_name", "last_name", "gender","password","status"};
	         
	         
	        csvWriter.writeHeader(csvHeader);
	         
	        for (Person person : perList) {
	            csvWriter.write(person, nameMapping);
	        }
	        csvWriter.close();
	        System.out.println("Written successfully in csv file!!");
	    }
	 
		public List<Person> findUserDetails() {
			List<Object[]> objArray = repo.findUserDetails();
			List<Person> perList = new ArrayList<Person>();
			for (int i = 0; i < objArray.size(); i++) {
				Object[] obj = objArray.get(0);
				Person per = new Person();
				per.setUsername((String) obj[0]);
				per.setFirst_name((String) obj[1]);
				per.setLast_name((String) obj[2]);
				perList.add(per);
			}
			return perList;
		}
	 
	 public void exportToCSVObjectArray(List<Person> perList) throws IOException {
		 
	        ICsvBeanWriter csvWriter = new CsvBeanWriter(new FileWriter("D:\\Person-Details.csv"), CsvPreference.STANDARD_PREFERENCE);
	        //user_id=1, username=rogers63, first_name=david, last_name=john, gender=Female, 
	        //password=e6a33eee180b07e563d74fee8c2c66b8, status=1
	       
	        String[] csvHeader =   {"username", "first_name", "last_name"};
	        String[] nameMapping = {"username", "first_name", "last_name"};
	        csvWriter.writeHeader(csvHeader);
	        
	        for (Person person:perList) {
				csvWriter.write(person, nameMapping);
				
			}
	        
	        csvWriter.close();
	        System.out.println("Written successfully in csv file!!");
	    }
}
