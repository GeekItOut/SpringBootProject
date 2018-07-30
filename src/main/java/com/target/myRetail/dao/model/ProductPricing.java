package com.target.myRetail.dao.model;

import javax.persistence.Table;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProductPricing")
@Data
// @Builder
@Table(name = "product_prices")
public class ProductPricing {

	public ProductPricing()
	{
		
	}
	@Id
	private long id;
	
	@Indexed(unique = true)
	private int productId;

	
	private double value;
	private String currency_code;
}
