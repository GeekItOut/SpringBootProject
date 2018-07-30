package com.target.myRetail.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response implements Serializable {
	private static final long serialVersionUID = 293759238759275000L;
	@NotNull
	@Pattern(regexp = "[0-9]{1,60}")
	@ApiModelProperty(notes = "The user given product ID")
	private int id;
	@Pattern(regexp = "[a-zA-Z]{0,100}")
	@ApiModelProperty(notes = "The name extracted from external API")
	private String name;
	@ApiModelProperty(notes = "The current price obtained from database")
	private CurrentPrice currentPrice;

}
