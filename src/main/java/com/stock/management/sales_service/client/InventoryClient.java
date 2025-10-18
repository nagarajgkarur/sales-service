package com.stock.management.sales_service.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "stock-service",path = "/api/v1/inventory")
public interface InventoryClient {

	
}
