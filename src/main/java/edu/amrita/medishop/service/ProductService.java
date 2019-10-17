package edu.amrita.medishop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.amrita.medishop.model.Product;
import edu.amrita.medishop.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * This method provides a list which contains the list of
	 * all the products in the database.
	 * @return: List of products present in the database
	 */
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	/**
	 * This method provides a Product with the id specified
	 * @param id: The id of the product that is to be returned
	 * @return: Product object with the specified id
	 */
	public Product getProductById(int id) {
		return productRepository.findById(id).get();
	}
	
	/**
	 * This method returns a Product with the specified name
	 * @param name: The name of the product that is required
	 * @return: Product object with the specified name
	 */
	public Product getProductByName(String name) {
		return productRepository.findProductByName(name);
	}
}
