package com.packt.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public void processOrder(String productId, int amount) {
		Product getProduct = productRepository.getProductById(productId);
		long itemsInStock = getProduct.getUnitsInStock();
		if (itemsInStock < amount) {
			throw new IllegalArgumentException("Not enough items to realize this order. "
					+ "There are: " + itemsInStock + "items in stock");
		}
		getProduct.setUnitsInStock(itemsInStock - amount);
		
	}
	
	
}
