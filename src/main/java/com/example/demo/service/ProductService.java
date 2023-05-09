package com.example.demo.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
@Service
public interface ProductService {
	

List<Product> getAllProducts();
Product getProductById(Long id);
 Product createProduct(Product product);
 Product updateProduct(Long id, Product productDetails);
 void deleteProduct(Long id);
List<Product>getAllPage(Integer PageNo,Integer PageSize);
}
