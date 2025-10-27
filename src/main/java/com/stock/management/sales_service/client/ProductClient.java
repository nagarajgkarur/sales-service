package com.stock.management.sales_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stock.management.sales_service.dto.ProductResponseEntity;

@FeignClient(name="product-service",path = "/api/v1/product")
public interface ProductClient {

	@GetMapping("/search")
	public ResponseEntity<ProductResponseEntity> getProductByPartId(@RequestParam("partId") String partId);
}
