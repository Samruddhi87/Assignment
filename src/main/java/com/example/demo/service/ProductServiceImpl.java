package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private  ProductRepository productRepository;
   
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }
public List<Product> getProductsByCategoryId(Long categoryId) {
    return productRepository.findByCategoryId(categoryId);
}

public Product createProduct(Product product) {
    return productRepository.save(product);
}

public Product updateProduct(Long id, Product productDetails) {
    Product product = getProductById(id);
    product.setName(productDetails.getName());
    product.setPrice(productDetails.getPrice());
    return productRepository.save(product);
}

public void deleteProduct(Long id) {
    Product product = getProductById(id);
    productRepository.delete(product);
}

public List<Product>getAllPage(Integer PageNo,Integer PageSize)
{
	org.springframework.data.domain.Pageable pageable=PageRequest.of(PageNo, PageSize);
	Page<Product> page= productRepository.findAll(pageable);
	return page.toList();
}


}


