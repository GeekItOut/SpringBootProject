package com.target.myRetail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.myRetail.dao.PriceDao;
import com.target.myRetail.dao.model.ProductPricing;
import com.target.myRetail.domain.CurrentPrice;
import com.target.myRetail.domain.Response;

@Service
public class ProductInfoService {

	@Autowired
	PriceDao priceDao;

	public Response getProductInfo(int productId) {
		Response response = Response.builder().build();

		// TODO:
		// 1.A service to get product name for id
		ProductPricing price = priceDao.findByProductId(productId);
		if (price != null) {
			response.setId(price.getProductId());
			CurrentPrice currentPrice = CurrentPrice.builder().build();
			currentPrice.setValue(price.getValue());
			currentPrice.setCurrency_code(price.getCurrency_code());
			response.setCurrentPrice(currentPrice);
		}

		return response;
	}
}
