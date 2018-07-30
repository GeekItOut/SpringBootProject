package com.target.myRetail.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.target.myRetail.dao.model.ProductPricing;

@Repository
public interface PriceDao {

	public ProductPricing findByProductId(int productId);

	public void create(ProductPricing prices);
}
