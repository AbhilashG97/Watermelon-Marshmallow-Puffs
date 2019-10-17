package edu.amrita.medishop.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.amrita.medishop.service.ProductService;

@RestController
public class ProductApiController {

	@Autowired
	ProductService productService;
	
}
