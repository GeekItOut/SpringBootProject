package com.target.myRetail.service;

import java.io.IOException;

import lombok.Builder;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.target.myRetail.config.YAMLConfig;

@Service
@Builder
public class ProductNameService {

	@Autowired
	YAMLConfig yamlConfig;

	/**
	 * This method connects to external api and return product name
	 * @param l
	 * @return
	 * @throws JSONException
	 * @throws IOException
	 */
	public String getProductName(long productID) throws JSONException, IOException {

		String url = yamlConfig.getExternalApiURL();

		String productName = "Product Name does not exist for this product id";

		RestTemplate restTemplate = new RestTemplate();
		;
		ResponseEntity<String> response = restTemplate.getForEntity(url,
				String.class);

		JsonElement root = new JsonParser().parse(response.getBody());
		JsonElement product = root.getAsJsonObject().get("product");
		JsonElement productIDRoot = product.getAsJsonObject().get(
				"available_to_promise_network");
		int productid = productIDRoot.getAsJsonObject().get("product_id")
				.getAsInt();
		if (productid == productID) {
			JsonElement productDescription = product.getAsJsonObject()
					.get("item").getAsJsonObject().get("product_description");

			productName = productDescription.getAsJsonObject().get("title")
					.getAsString();
		}
		return productName;

	}

}
