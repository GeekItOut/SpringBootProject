package com.target.myRetail.dao.model;

import java.math.BigDecimal;

import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProductPricing")
@Data
@Table(name = "product_prices")
public class ProductPricing {

	public ProductPricing() {

	}

	@Id
	private long id;

	@Indexed(unique = true)
	@Pattern(regexp = "[0-9]{1,60}")
	private int productId;
	@Pattern(regexp = "[0-9]{1,10}[.][0-9]{0,2}")
	private BigDecimal value;
	@Pattern(regexp = "USD:?")
	private String currency_code;
}
