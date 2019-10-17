package edu.amrita.medishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.amrita.medishop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
