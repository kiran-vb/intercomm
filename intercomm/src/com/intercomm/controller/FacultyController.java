package com.intercomm.controller;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.intercomm.pojo.Faculty;
import com.intercomm.util.SpringMongoConfig1;
import com.mongodb.DBCollection;

@RestController
public class FacultyController {
	private static final Logger logger = Logger.getLogger(FacultyController.class);
	@RequestMapping(value ="/api/addFaculty")
	@ResponseBody
	public String addStudent(@RequestBody String facultyInfo){
		logger.debug("FacultyController debug :::: addStudent()");
		logger.info( "FacultyController info:::: addStudent()");
		System.out.println("Faculty JSON is  :::: "+facultyInfo );
		
		JSONObject jsonObj= new JSONObject();
		
		//mongoTemplate.
	
		Gson gson=new Gson();
		Faculty faculty = gson.fromJson(facultyInfo, Faculty.class);
		System.out.println("Faculty is ::: " +faculty);
		jsonObj.put("info", "success");
		
		
		
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig1.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		
		DBCollection dbcoll = mongoOperation.getCollection("users");
		
		
		mongoOperation.insert(faculty);
		
		System.out.println("DB collection doc count :::: " + dbcoll.count());
		
		
	
		return jsonObj.toString();
	}
}
