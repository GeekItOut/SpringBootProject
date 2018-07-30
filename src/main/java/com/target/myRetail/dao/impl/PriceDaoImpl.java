package com.target.myRetail.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoWriteException;
import com.target.myRetail.dao.PriceDao;
import com.target.myRetail.dao.model.ProductPricing;

@Repository
public class PriceDaoImpl implements PriceDao {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public ProductPricing findByProductId(int productId) {
		// TODO Auto-generated method stub
		List<ProductPricing> price = new ArrayList<ProductPricing>();
		if (mongoTemplate.collectionExists(ProductPricing.class)) {
			Query query = new Query(Criteria.where("productId").is(productId));

			price = mongoTemplate.find(query, ProductPricing.class);
		}
		return price.get(0);
	}

	@Override
	public void create(ProductPricing prices) {
		// TODO Auto-generated method stub
		if (!mongoTemplate.collectionExists(ProductPricing.class)) {
			mongoTemplate.createCollection(ProductPricing.class);

		}
		try {
			mongoTemplate.insert(prices);
		} catch (MongoWriteException e) {
			System.out.println(e.getMessage());
		}

	}

}
