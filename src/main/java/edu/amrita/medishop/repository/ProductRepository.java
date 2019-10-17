package edu.amrita.medishop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.amrita.medishop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByNameContaining(String name);
	
}
