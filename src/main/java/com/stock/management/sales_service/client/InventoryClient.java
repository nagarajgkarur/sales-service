package com.stock.management.sales_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stock.management.sales_service.dto.InventoryResponseEntity;

@FeignClient(name = "stock-service",path = "/api/v1/inventory")
public interface InventoryClient {
	
	
	@PutMapping("")
	public ResponseEntity<InventoryResponseEntity> updateInventoryStock(@RequestParam("inTakeCount") int inTakeCount, 
			@RequestParam("price") Double price, @RequestParam("partId") String partId,@RequestParam("action") String action);

	
}
