package com.intercomm.controller;

import java.io.IOException;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.misc.BASE64Decoder;

@Controller
public class AuthController {

	//http://localhost:9073/api/authTest/1016
	
	@RequestMapping(value ="/api/authTest")
	@ResponseBody
	public String authCheck(@PathParam("orderId") Integer orderId, 
            @HeaderParam("authorization") String authString){
		System.out.println("from authCheck :::::");
		boolean b = isUserAuthenticated(authString);
		System.out.println("auth is :::: " + b);
		return b+ "";
	}
	
	private boolean isUserAuthenticated(String authString){
        
        String decodedAuth = "";
        // Header is in the format "Basic 5tyc0uiDat4"
        // We need to extract data before decoding it back to original string
        String[] authParts = authString.split("\\s+");
        String authInfo = authParts[1];
        // Decode the data back to original string
        byte[] bytes = null;
        try {
            bytes = new BASE64Decoder().decodeBuffer(authInfo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        decodedAuth = new String(bytes);
        System.out.println(decodedAuth);
         
        /**
         * here you include your logic to validate user authentication.
         * it can be using ldap, or token exchange mechanism or your 
         * custom authentication mechanism.
         */
        // your validation code goes here....
         
        return true;
    }
}
