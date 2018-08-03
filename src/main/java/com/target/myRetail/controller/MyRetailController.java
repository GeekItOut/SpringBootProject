package com.target.myRetail.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.target.myRetail.dao.PriceDao;
import com.target.myRetail.dao.model.ProductPricing;
import com.target.myRetail.domain.Response;
import com.target.myRetail.service.ProductInfoService;

@RestController
@Api(value = "myRetail", description = "An API to return price and name information of a product")
public class MyRetailController {
	@Autowired
	ProductInfoService productInfoService;
	@Autowired
	PriceDao priceDao;

	@ApiOperation(value = "View or update product info ", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved/updated list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/products/{productID}", method = {
			RequestMethod.GET, RequestMethod.PUT }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Response getResponseForProductId(@PathVariable int productID,
			@RequestParam(required = false) ProductPricing productPricing)
			throws JSONException, IOException {
		Response response = Response.builder().build();
		if (productPricing != null) {
			updateProductPricing(productPricing);
		} else {

			response = productInfoService.getProductInfo(productID);
		}
		return response;
	}

	@ApiOperation(value = "Add a product info")
	public void updateProductPricing(ProductPricing productPricing) {
		priceDao.create(productPricing);

	}
}
