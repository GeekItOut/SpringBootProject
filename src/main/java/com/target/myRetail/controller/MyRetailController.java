package com.target.myRetail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.target.myRetail.dao.PriceDao;
import com.target.myRetail.dao.model.ProductPricing;
import com.target.myRetail.domain.Response;
import com.target.myRetail.service.ProductInfoService;

@RestController
public class MyRetailController {
	@Autowired
	ProductInfoService productInfoService;
	@Autowired
	PriceDao priceDao;

	@RequestMapping(path = "/products/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Response getResponseForProductId(int productID) {
		Response response = Response.builder().build();

		response = productInfoService.getProductInfo(productID);
		return response;
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public void createProductPricing(@RequestBody ProductPricing productPricing) {
		priceDao.create(productPricing);

	}
}
