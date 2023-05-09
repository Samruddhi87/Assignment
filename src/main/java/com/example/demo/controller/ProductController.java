package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	 private final ProductService productService;

	    @Autowired
	    public ProductController(ProductService productService) {
	        this.productService = productService;
	    }

	    @RequestMapping(value = "/produts/{id}", method = RequestMethod.GET)
	    public Product getProductById(@PathVariable Long id) {
	        return productService.getProductById(id);
	    }



	    @RequestMapping(value = "/produts", method = RequestMethod.POST)	   
	    public Product createProduct(@RequestBody Product product) {
	        return productService.createProduct(product);
	    }

//	    @PutMapping("/{id}")
	    @RequestMapping(value = "/produts/{id}", method = RequestMethod.PUT)	   

	    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
	        return productService.updateProduct(id, productDetails);
	    }

	   
	    @RequestMapping(value = "/produts/{id}", method = RequestMethod.DELETE)	   
	    public void deleteProduct(@PathVariable Long id) {
	        productService.deleteProduct(id);
	    }
	    
	    @RequestMapping(value = "/page", method = RequestMethod.GET)
	    public List<Product> getAllPage(@RequestParam(defaultValue = "0")int PageNo, @RequestParam(defaultValue = "5")int PageSize)
	    {
	    	
	    	return productService.getAllPage(PageNo, PageSize);
	    }

	   
	    
		
}
