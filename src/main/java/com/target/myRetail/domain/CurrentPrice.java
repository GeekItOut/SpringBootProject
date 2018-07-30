package com.target.myRetail.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Pattern;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrentPrice implements Serializable {
	private static final long serialVersionUID = 293759238759275339L;
	@Pattern(regexp = "[0-9]{1,10}[.][0-9]{0,2}")
	@ApiModelProperty(notes = "The price value retrieved from the database")
	private BigDecimal value;
	@Pattern(regexp = "USD:?")
	@ApiModelProperty(notes = "The price currency code retrieved from the database")
	private String currency_code;
}
