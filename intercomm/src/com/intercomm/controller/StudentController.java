package com.intercomm.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.intercomm.pojo.Student;
import com.intercomm.util.SpringMongoConfig1;
import com.mongodb.DBCollection;

@RestController
public class StudentController {
	private static final Logger logger = Logger.getLogger(StudentController.class);
	@RequestMapping(value ="/api/getStudentList")
	@ResponseBody
	public String getStudentsList(){
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig1.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		
		return new Gson().toJson(mongoOperation.findAll(Student.class));
	}
}
