package com.target.myRetail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.myRetail.dao.PriceDao;
import com.target.myRetail.domain.Response;

@Service
public class ProductInfoService {

	@Autowired
	PriceDao priceDao ;
	public Response getProductInfo(int productId)
	{
		Response response = Response.builder().build();
		//TODO:
		//1.A service to get product name for id
		response = priceDao.findByProductId(productId);
		return response;
	}
}
