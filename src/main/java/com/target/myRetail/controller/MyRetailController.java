package com.target.myRetail.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
@Api(value = "myRetail", description = "An API to return price and name information of a product")
public class MyRetailController {
	@Autowired
	ProductInfoService productInfoService;
	@Autowired
	PriceDao priceDao;

	@ApiOperation(value = "View a list of available products", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path = "/products/{productID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Response getResponseForProductId(@PathVariable int productID) {
		Response response = Response.builder().build();

		response = productInfoService.getProductInfo(productID);
		return response;
	}

	@ApiOperation(value = "Add a product info")
	@RequestMapping(path = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public void createProductPricing(@RequestBody ProductPricing productPricing) {
		priceDao.create(productPricing);

	}
}
