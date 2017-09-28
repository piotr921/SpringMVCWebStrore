package com.packt.webstore.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;
import org.springframework.web.multipart.MultipartFile;

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

	@Override
	public List<Product> getProductsByManufacturer(String manufacturer) {
		return repository.getProductsByManufacturer(manufacturer);
	}

	@Override
	public void addProduct(Product product) {
		repository.addProduct(product);
	}

	@Override
	public void updateProductPicture(String id, MultipartFile picture) {
		repository.updateProductPicture(id, picture);
	}

	@Override
	public Set<Product> getProductByPriceFilter(Map<String, List<String>> priceRanges) {
		return repository.getProductsByPriceFilter(priceRanges);
	}
}
