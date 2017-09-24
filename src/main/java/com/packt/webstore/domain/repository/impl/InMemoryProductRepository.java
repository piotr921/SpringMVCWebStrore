package com.packt.webstore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;

@Repository
public class InMemoryProductRepository implements ProductRepository {

	private List<Product> products = new ArrayList<>();

	public InMemoryProductRepository() {
		Product iphone = new Product("P1235", "iPhone 0s", new BigDecimal(1350));
		iphone.setDescription(
				"New model of well-known Apple company, it has no headphones, but instead of that got Apple mark");
		iphone.setCategory("Smartphone");
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
		Product getProduct = products.stream().filter(product -> product.getProductId().equals(productId)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException(
						"Product with id: " + productId + "doesn't exist in our store"));
		return getProduct;
	}

	@Override
	public List<Product> getPrductsByCategory(String category) {
		List<Product> getProducts = products.stream().filter(product -> product.getCategory().equals(category))
				.collect(Collectors.toList());
		return getProducts;
	}

	@Override
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		Set<Product> productsByBrand = new HashSet<>();
		Set<Product> productByCategory = new HashSet<>();
		Set<String> criterias = filterParams.keySet();

		if (criterias.contains("brand")) {
			for (String brandName : filterParams.get("brand")) {
				products.forEach(product -> {
					if (brandName.equalsIgnoreCase(product.getManufacturer())) {
						productsByBrand.add(product);
					}
				});
			}
		}

		if (criterias.contains("category")) {
			for (String category : filterParams.get("category")) {
				productByCategory.addAll(this.getPrductsByCategory(category));
			}
		}
		productByCategory.retainAll(productsByBrand);
		return productByCategory;
	}

	@Override
	public List<Product> getProductsByManufacturer(String manufacturer) {
		return products.stream().filter(product -> product.getManufacturer().equalsIgnoreCase(manufacturer))
				.collect(Collectors.toList());
	}

	@Override
	public Set<Product> getProductsByPriceFilter(Map<String, List<String>> pricesRange) {
		List<String> prices = pricesRange.get("price");
		BigDecimal low = new BigDecimal(200);
		BigDecimal high = new BigDecimal(400);

		System.out.println(Integer.valueOf(prices.get(0).substring(prices.get(0).indexOf('='))));

		return products.stream()
				.filter(product -> product.getUnitPrice().compareTo(low) > 0)
				.filter(product -> product.getUnitPrice().compareTo(high) < 0)
				.collect(Collectors.toSet());
	}
}
