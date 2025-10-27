package com.stock.management.sales_service.service.utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.stock.management.sales_service.client.ProductClient;
import com.stock.management.sales_service.domain.Sales;
import com.stock.management.sales_service.domain.Shop;
import com.stock.management.sales_service.dto.ItemsPayload;
import com.stock.management.sales_service.dto.ProductResponse;
import com.stock.management.sales_service.dto.ProductResponseEntity;
import com.stock.management.sales_service.dto.SalesInvoicePayload;
import com.stock.management.sales_service.dto.SalesResponse;
import com.stock.management.sales_service.repository.SalesRepository;
import com.stock.management.sales_service.repository.ShopRepository;


@Component
public class SalesUtility {
	
	@Autowired
	SalesRepository salesRepository;
	
	@Autowired
	ShopRepository shopRepository;
	
	@Autowired
	ProductClient productClient;
	
	public List<SalesResponse> getSalesResponses(List<Sales> salesList) {
		return salesList.stream().map(e->getSalesResponse(e)).collect(Collectors.toList());
	}
	
	
	public SalesResponse getSalesResponse(Sales sales) {
		SalesResponse salesResponse = new SalesResponse();
		salesResponse.setId(sales.getId());
		salesResponse.setBillNumber(sales.getBillNumber());
		salesResponse.setCreatedAt(sales.getCreatedAt());
		salesResponse.setPartId(sales.getPartId());
		salesResponse.setQuantity(sales.getQuantity());
		salesResponse.setShopId(sales.getShop().getShopId());
		salesResponse.setSubTotal(sales.getSubTotal());
		salesResponse.setUnitPrice(sales.getUnitPrice());
		salesResponse.setUpdatedAt(sales.getUpdatedAt());
		return salesResponse;
	}

	public Sales getSales(ItemsPayload itemsPayload,Long billNumber) {
		Sales sales =  new Sales();
		sales.setBillNumber(billNumber);
		if(itemsPayload.getPartId() != null) {
			sales.setPartId(itemsPayload.getPartId());
			ResponseEntity<ProductResponseEntity> proResponseEntity =  productClient.getProductByPartId(itemsPayload .getPartId());
			ProductResponseEntity productResponseEntity = proResponseEntity.getBody();
			if(productResponseEntity.getProducts() != null) {
				ProductResponse productResponse = productResponseEntity.getProducts().get(0);
				sales.setPartName(productResponse.getPartName());
				sales.setPartDescription(productResponse.getPartDescription());
			}
		}
		
		if(itemsPayload.getQuantity()!=null) {
			sales.setQuantity(itemsPayload.getQuantity());
		}
		
		if(itemsPayload.getShopId() != null) {
			Shop shop = shopRepository.findById(itemsPayload.getShopId()).orElseThrow();
			sales.setShop(shop);
		}
		
		if(itemsPayload.getUnitPrice() != null) {
			sales.setUnitPrice(itemsPayload.getUnitPrice());
		}
		
		Double unitPrice = itemsPayload.getUnitPrice();
		Integer quentity = itemsPayload.getQuantity();
		sales.setSubTotal(unitPrice*quentity);
		sales.setCreatedAt(LocalDateTime.now());
		sales = salesRepository.save(sales);	
		return sales;
	}


	

}
