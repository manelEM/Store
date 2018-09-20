package com.youtube.store.domain;

import com.youtube.store.utilities.Connection;

public class ProductMethods {
	
	private Connection connection;
	public void add(Product product)
	{
		
		String id=product.getId();
		String description=product.getDescription();
		float price=product.getPrice();
		String sql="insert into product (id,description,price) values ('"+id+"','"+description+"',"+price+")";
		connection.executeUpdate(sql);
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
