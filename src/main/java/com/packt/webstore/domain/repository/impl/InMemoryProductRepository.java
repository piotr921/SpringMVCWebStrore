package com.packt.webstore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;

@Repository
public class InMemoryProductRepository implements ProductRepository {
	
	private List<Product> products = new ArrayList<>();
	
	public InMemoryProductRepository() {
		Product iphone = new Product("P1235", "iPhone 0s", new BigDecimal(1350));
		iphone.setDescription("New model of well-known Apple company, it has no headphones, but instead of that got Apple mark");
		iphone.setCategory("Smart Phone");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(100);
		
		Product amdProcessor = new Product("P008", "Ryzen", new BigDecimal(875));
		amdProcessor.setDescription("New processor model with a lot of cores, still worse than Intel");
		amdProcessor.setCategory("Processor");
		amdProcessor.setManufacturer("AMD");
		amdProcessor.setUnitsInStock(250);
		
		Product iwatch = new Product("P800", "iWatch", new BigDecimal(250));
		iwatch.setDescription("Smart watch, which informes you about messages comming to your iPhone");
		iwatch.setCategory("Watch");
		iwatch.setManufacturer("Apple");
		iwatch.setUnitsInStock(150);
		
		products.add(iphone);
		products.add(amdProcessor);
		products.add(iwatch);
	}

	@Override
	public List<Product> getAllProducts() {
		return products;
	}
	
	@Override
	public Product getProductById(String productId) {
		Product getProduct = products.stream()
				.filter(product -> product.getProductId().equals(productId))
				.findFirst().orElseThrow(
						() -> new IllegalArgumentException("Product with id: "
						 + productId + "doesn't exist in our store"));
		return getProduct;
	}
}
