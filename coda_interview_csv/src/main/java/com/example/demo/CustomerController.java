package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

	@Autowired
	private CustomerManager customerManager;

	private static final Logger logger = LoggerFactory.getLogger(String.class);

	@GetMapping("/generateJsonCustInfo")
	public ResponseEntity<?> getCustomerInfo() {
		try {
			customerManager.startFileTransaction();
			return ResponseEntity.status(HttpStatus.OK).body("Json files has been created!");
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected Error Occur, please contact support.");
		}
	}

}
