package de.biba.trick.template.add.on.service.controller;

import org.apache.xerces.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import de.biba.trick.template.add.on.service.dmo.LoginInput;
import de.biba.trick.template.add.on.service.dmo.RequestData;

/**
 * This is the controller to perform the data exchnage with the TRICK platform (EDM). The endpoint is always the Public API Microservice 
 * @author fma
 *
 */



@RestController
public class EDMController {

	@Autowired
	PublicAPIServiceController publicAPIService;
	
	/**
	 * It returns all available products in the marketplace
	 * @param input
	 * @return
	 */
	 @CrossOrigin
		@PostMapping(path = "/getProducts", consumes = "application/json", produces = "application/json")
		public Object login(@RequestBody LoginInput input ){
		 
		 Gson gson = new Gson();
		 String requestAsJSON = gson.toJson(input);
		 String requestAsBase64 = Base64.encode(requestAsJSON.getBytes());
		 RequestData inputForService = new RequestData();
		 inputForService.setBase64Inputdata(requestAsBase64);
		 
		Object r = publicAPIService.invoke("getProducts", inputForService);
		
		return r;
		 
	 }
	
}
