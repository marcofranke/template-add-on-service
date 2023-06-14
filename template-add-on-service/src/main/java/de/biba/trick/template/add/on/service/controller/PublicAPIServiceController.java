package de.biba.trick.template.add.on.service.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import de.biba.trick.template.add.on.service.dmo.RequestData;

/**
 * It is an interface to the The Public Platform API microservice. It is a
 * gateway that connects the B2B Marketplace and the TRICK business services to
 * the TRICK platform, whereby the TRICK core services (EDM & Security Broker)
 * are in focus. In doing so, an endpoint of the Public Platform API
 * microservice can be mapped directly to one endpoint of the core services
 * (1:1) or a sequence of endpoints (1:N). The mapping allows the mapping of
 * parameters as well as the change of the HTTP message type, whereby only HTTP
 * GET and HTTP Post are supported
 * 
 * @author fma
 *
 */

@FeignClient(value = "public-api-service", url = "https://www.trick.ikap.biba.uni-bremen.de/public-api-service/", fallbackFactory = PublicAPIServiceControllerFallback.class)
public interface PublicAPIServiceController {
	@CrossOrigin
	@PostMapping(path = "/invoke/{function}", consumes = "application/json", produces = "application/json")
	public Object invoke(@PathVariable("function") String function, @RequestBody RequestData input);

	@CrossOrigin
	@GetMapping(value = "/config")
	public String config();

}
