package com.youtube.store.test;

import com.youtube.store.domain.Product;
import com.youtube.store.domain.ProductMethods;
import com.youtube.store.utilities.Connection;
import com.youtube.store.utilities.ConnectionFactory;

public class Test {

	public static void main(String[] args) {
	String id ="c109";
	String description="carpet";
	float price=600;
	
	Connection connection=ConnectionFactory.createConnection();
	Product product=new Product();
	product.setId(id);
	product.setDescription(description);
	product.setPrice(price);
	
	ProductMethods productMethods=new ProductMethods();
	productMethods.setConnection(connection);
	productMethods.add(product);

	
	}
}
