package com.stock.management.sales_service.service.utility;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stock.management.sales_service.domain.Sales;
import com.stock.management.sales_service.domain.Shop;
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

	public Sales getSales(SalesInvoicePayload salesInvoicePayload,Long id) {
		Sales sales = null;
		if(id==null) {
			sales = new Sales();
		}else {
			sales = salesRepository.findById(id).orElseThrow();
		}
		if(salesInvoicePayload.getBillNumber() != null) {
			sales.setBillNumber(salesInvoicePayload.getBillNumber());
		}
		
		if(salesInvoicePayload.getPartId() != null) {
			sales.setPartId(salesInvoicePayload.getPartId());;
		}
		
		if(salesInvoicePayload.getQuantity()!=null) {
			sales.setQuantity(salesInvoicePayload.getQuantity());
		}
		
		if(salesInvoicePayload.getShopId() != null) {
			Shop shop = shopRepository.findById(salesInvoicePayload.getShopId()).orElseThrow();
			sales.setShop(shop);
		}
		
		if(salesInvoicePayload.getUnitPrice() != null) {
			sales.setUnitPrice(salesInvoicePayload.getUnitPrice());
		}
		return sales;
	}

}
