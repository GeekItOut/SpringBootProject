package com.target.myRetail.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.target.myRetail.dao.model.ProductPricing;
import com.target.myRetail.domain.Response;

@Repository
public interface PriceDao extends JpaRepository<ProductPricing, Long>{

	public Response findByProductId(int productId);
}
