package com.klu;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{
	
	List<Product> findByCategory(String category);
	
	//display by category and price
	  List<Product> findByCategoryAndPriceGreaterThan(String category,double price);
	  
	//display by min-max
	  List<Product> findByPriceBetween(long min, long max);
	  
	//countby category
	  
	  long countByCategory(String category);
	  
	  //deleteby name
	  
	  @Transactional
	  void deleteByName(String name);
	  
	  Optional<Product> findByName(String name);

}
