package com.packt.webstore.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.packt.webstore.domain.Product;

public interface ProductService {
	List<Product> getAllProducts();
	List<Product> getProductsByCategory(String category);
	Product getProductById(String productId);
	Set<Product> getProductByFilter(Map<String, List<String>> fileParams);
	Set<Product> getProductByPriceFilter(Map<String, List<String>> priceRanges);
	List<Product> getProductsByManufacturer(String manufacturer);
}
