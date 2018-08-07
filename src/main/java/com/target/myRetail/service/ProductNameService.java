package com.target.myRetail.service;

import java.io.IOException;

import lombok.Builder;

import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Service
@Builder
public class ProductNameService {
	public String getProductName(long l) throws JSONException,
			IOException {
		String productName = "Product Name does not exist for this product id";
		String url = "https://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
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
		if (productid == l) {
			JsonElement productDescription = product.getAsJsonObject()
					.get("item").getAsJsonObject().get("product_description");

			productName = productDescription.getAsJsonObject().get("title")
					.getAsString();
		}
		return productName;

	}

}
