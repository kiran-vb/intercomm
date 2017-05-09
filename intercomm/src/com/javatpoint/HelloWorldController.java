package com.javatpoint;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
private static final Logger logger = Logger.getLogger(HelloWorldController.class);

	@RequestMapping("/hello.html")
	public ModelAndView helloWorld(){
		/*logger.debug("HelloWorldController :::: helloWorld()");
		logger.info("HelloWorldController :::: helloWorld()");*/
		
		logger.debug("HelloWorldController :::: helloWorld()");
		logger.info( "HelloWorldController :::: helloWorld()");
						
		System.out.println("from Hello World !!!");
		String message="Hello Spring MVC how r u";
		return new ModelAndView("hellopage","message",message);
	}
}
