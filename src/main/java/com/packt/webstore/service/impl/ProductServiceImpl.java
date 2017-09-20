package com.packt.webstore.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository repository;

	@Override
	public List<Product> getAllProducts() {
		return repository.getAllProducts();
	}

	@Override
	public Product getProductById(String productId) {
		return repository.getProductById(productId);
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		return repository.getPrductsByCategory(category);
	}

	@Override
	public Set<Product> getProductByFilter(Map<String, List<String>> fileParams) {
		return repository.getProductsByFilter(fileParams);
	}
}
