package com.target.myRetail.dao.model;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "ProductPricing")
@Data
@Table(name = "product_prices")
public class ProductPricing {
	

	
	@NotNull
	@ApiModelProperty(notes = "The database generated ID")
	private long id;

	//@Indexed(unique = true)
	@NotNull
	@Pattern(regexp = "[0-9]{1,60}")
	@ApiModelProperty(notes = "The user given product ID")
	private long productId;
	@Pattern(regexp = "[0-9]{1,10}[.][0-9]{0,2}")
	@ApiModelProperty(notes = "The price value retrieved from the database")
	private BigDecimal value;
	@Pattern(regexp = "USD:?")
	@ApiModelProperty(notes = "The currency code retrieved from the database")
	private String currency_code;
}
