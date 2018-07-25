package com.target.myRetail.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "product_prices")
public class ProductPricing {

	private int productId;
	
	@Column(columnDefinition = "value")
	private double priceValue;
	
	@Column(columnDefinition = "currency")
	private double currency;
}
