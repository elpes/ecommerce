package com.ecommerce.repository;
import org.springframework.stereotype.Repository;
import com.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}