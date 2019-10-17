package edu.amrita.medishop.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.amrita.medishop.model.Product;
import edu.amrita.medishop.service.ProductService;

@RestController
public class ProductApiController {

	@Autowired
	ProductService productService;
	
	@RequestMapping("/api/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@RequestMapping("/api/products/product/id/{id}")
	public Product getProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	
	@RequestMapping("/api/products/product/name/{name}")
	public List<Product> getProductByName(@PathVariable String name) {
		return productService.getProductByName(name);
	}
}
