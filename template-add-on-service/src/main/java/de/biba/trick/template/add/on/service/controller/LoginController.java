package de.biba.trick.template.add.on.service.controller;

import org.apache.xerces.impl.dv.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import de.biba.trick.template.add.on.service.dmo.GetUserInput;
import de.biba.trick.template.add.on.service.dmo.LoginInput;
import de.biba.trick.template.add.on.service.dmo.RequestData;
import de.biba.trick.template.add.on.service.dmo.Token;
import de.biba.trick.template.add.on.service.dmo.User;




/**
 * This is the controller to perform a login and to ask for the user data. The endpoint is always the Public API Microservice 
 * @author fma
 *
 */

@RestController
public class LoginController {

	@Autowired
	PublicAPIServiceController publicAPIService;
	
	 private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	 @CrossOrigin
	    @GetMapping(value = "/infoLogin")
	    public String config() {
	        logger.info("Invoke method: infoLogin");

	        String r = "It uses the public api microsrvice to get in toach with the TRICK Security Broker";

	        return r;
	    }

	 
	 /**
	  * It performs a login with an e-mail adresses and a password
	  * @param input
	  * @return
	  */
	 
	 @CrossOrigin
		@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
		public Object login(@RequestBody LoginInput input ){
		 
		 Gson gson = new Gson();
		 String requestAsJSON = gson.toJson(input);
		 String requestAsBase64 = Base64.encode(requestAsJSON.getBytes());
		 RequestData inputForService = new RequestData();
		 inputForService.setBase64Inputdata(requestAsBase64);
		 
		Object r = publicAPIService.invoke("login", inputForService);
		
		return r;
		 
	 }
	 
	 /**
	  * Performs a log in and then ask for the user details
	  */
	 
	 @CrossOrigin
		@PostMapping(path = "/getUserDetails", consumes = "application/json", produces = "application/json")
		public User getUserDetails(@RequestBody LoginInput input ){
		 
		 Object token = login (input);
		 Gson gson = new Gson();
		 Token tokenAsObject = gson.fromJson(String.valueOf(token), Token.class); 
		 RequestData inputForService = new RequestData();
		 inputForService.setoAuthToken(tokenAsObject.getToken());
		 
		 GetUserInput inputUser = new GetUserInput();
		 inputUser.setUsername(input.getUsername());
		 
		 String requestAsJSON = gson.toJson(inputUser); //Shall not be empty
		 String requestAsBase64 = Base64.encode(requestAsJSON.getBytes());
		 inputForService.setBase64Inputdata(requestAsBase64);
		 
		Object r =  publicAPIService.invoke("getUserDetails", inputForService);
		String str = gson.toJson(r);
		User user = gson.fromJson(str, User.class);
		
		return user;
		 
	 }
	 
}
