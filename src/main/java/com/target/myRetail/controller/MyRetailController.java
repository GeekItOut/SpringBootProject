package com.target.myRetail.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.target.myRetail.domain.Response;

@RestController
public class MyRetailController {
	@RequestMapping(path = "/products/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Response getResponseForProductId(@PathVariable int productID) {
		Response response = Response.builder().build();
		// TODO:Call appropriate IMPL
		return response;
	}
}
