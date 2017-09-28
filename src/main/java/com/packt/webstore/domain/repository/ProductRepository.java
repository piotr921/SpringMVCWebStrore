package com.packt.webstore.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.packt.webstore.domain.Product;
import org.springframework.web.multipart.MultipartFile;

public interface ProductRepository {
	List<Product> getAllProducts();
	List<Product> getPrductsByCategory(String category);
	Product getProductById(String productId);
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	Set<Product> getProductsByPriceFilter(Map<String, List<String>> pricesRange);
	List<Product> getProductsByManufacturer(String manufacturer);
	void addProduct(Product product);
	void updateProductPicture(String id, MultipartFile picture);
}
