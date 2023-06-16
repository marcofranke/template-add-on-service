package de.biba.trick.template.add.on.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import de.biba.trick.template.add.on.service.dmo.LoginInput;
import de.biba.trick.template.add.on.service.dmo.RequestData;
import de.biba.trick.template.add.on.service.dmo.Token;

/**
 * This is the controller to perform the data exchnage with the TRICK platform (EDM). The endpoint is always the Public API Microservice 
 * @author fma
 *
 */



@RestController
public class EDMController {

	@Autowired
	PublicAPIServiceController publicAPIService;
	
	@Autowired
	LoginController loginController;
	
	/**
	 * It returns all available products in the marketplace
	 * @param input
	 * @return
	 */
	 @CrossOrigin
		@PostMapping(path = "/getProducts", consumes = "application/json", produces = "application/json")
		public Object getProducts(@RequestBody LoginInput input ){
		 
		 Object token = loginController.login (input);
		 Gson gson = new Gson();
		 Token tokenAsObject = gson.fromJson(String.valueOf(token), Token.class); 
		 RequestData inputForService = new RequestData();
		 inputForService.setoAuthToken(tokenAsObject.getToken());
		 
		 System.out.println("Found token: " + tokenAsObject);
		 
		Object r = publicAPIService.invoke("getProducts", inputForService);
		
		return r;
		 
	 }
	
}
