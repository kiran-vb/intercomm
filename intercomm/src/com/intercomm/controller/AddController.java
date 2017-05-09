package com.intercomm.controller;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.intercomm.pojo.Student;
import com.intercomm.util.SpringMongoConfig1;
import com.mongodb.DBCollection;



@Controller
public class AddController {
	private static final Logger logger = Logger.getLogger(AddController.class);
	
  
	@RequestMapping(value ="/api/addStudent")
	@ResponseBody
	public String addStudent(@RequestBody String studentInfo){
		logger.debug("AddController debug :::: addStudent()");
		logger.info( "AddController info:::: addStudent()");
		System.out.println("Student JSON is  :::: "+studentInfo );
		
		JSONObject jsonObj= new JSONObject();
		
		//mongoTemplate.
	
		Gson gson=new Gson();
		Student student = gson.fromJson(studentInfo, Student.class);
		System.out.println("Student is ::: " +student);
		jsonObj.put("info", "success");
		
		
		
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig1.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		
		DBCollection dbcoll = mongoOperation.getCollection("users");
		
		
		mongoOperation.insert(student);
		
		System.out.println("DB collection doc count :::: " + dbcoll.count());
		
		
	
		return jsonObj.toString();
	}

}
