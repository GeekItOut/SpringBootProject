package com.target.myRetail.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrentPrice implements Serializable{
 private static final long serialVersionUID = 293759238759275339L;
 
 private BigDecimal value;
 private String currency_code;
}
