package com.target.myRetail.domain;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response implements Serializable {
	private static final long serialVersionUID = 293759238759275000L;
	private int id;
	private String name;
	private CurrentPrice currentPrice;

}
