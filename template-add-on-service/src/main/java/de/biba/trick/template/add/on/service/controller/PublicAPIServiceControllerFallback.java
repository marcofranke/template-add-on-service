package de.biba.trick.template.add.on.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import feign.hystrix.FallbackFactory;

public class PublicAPIServiceControllerFallback  implements FallbackFactory<PublicAPIServiceController>{

	
	 private static final Logger logger = LoggerFactory.getLogger(PublicAPIServiceControllerFallback.class);
	
	public PublicAPIServiceController create(Throwable cause) {
		// TODO Auto-generated method stub
		logger.error(cause.getLocalizedMessage());
		return null;
	}

}
