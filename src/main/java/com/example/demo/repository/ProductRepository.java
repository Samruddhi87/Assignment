package com.example.demo.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;
@Repository
public interface ProductRepository  extends JpaRepository<Product, Long>   {
	  List<Product> findByCategoryId(Long categoryId);
//	  Page<Product> proPageable(Pageable pageable);

}
