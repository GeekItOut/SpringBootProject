package com.target.myRetail.domain;

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
	private int id;
	@Pattern(regexp = "[a-zA-Z]{0,100}")
	private String name;
	private CurrentPrice currentPrice;

}
