package com.target.myRetail.service;

import java.io.IOException;

import org.json.JSONException;
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
	@Autowired
	ProductNameService productNameService;

	/**
	 * This method returns the response object
	 * 
	 * @param productId
	 * @return
	 * @throws JSONException
	 * @throws IOException
	 */
	public Response getProductInfo(int productId) throws JSONException,
			IOException {
		Response response = Response.builder().build();

		// 1.A service to get product name for id
		ProductPricing price = priceDao.findByProductId(productId);
		if (price != null) {
			response = prepareResponse(price);
		}

		return response;
	}

	/**
	 * This method updates price
	 * 
	 * @param productPricing
	 * @return
	 * @throws JSONException
	 * @throws IOException
	 */
	public Response updateProductInfo(ProductPricing productPricing)
			throws JSONException, IOException {
		Response response = Response.builder().build();

		// 1.A service to update
		ProductPricing price = priceDao.update(productPricing);
		if (price != null) {
			response = prepareResponse(price);

		}

		return response;
	}

	/**
	 * This method prepares the response
	 * 
	 * @param price
	 * @return
	 * @throws JSONException
	 * @throws IOException
	 */
	private Response prepareResponse(ProductPricing price)
			throws JSONException, IOException {
		Response response = Response.builder().build();
		// TODO Auto-generated method stub
		response.setId(price.getProductId());
		CurrentPrice currentPrice = CurrentPrice.builder().build();
		currentPrice.setValue(price.getValue());
		currentPrice.setCurrency_code(price.getCurrency_code());
		response.setCurrentPrice(currentPrice);
		response.setName(productNameService.getProductName(price.getProductId()));
		return response;
	}
}
