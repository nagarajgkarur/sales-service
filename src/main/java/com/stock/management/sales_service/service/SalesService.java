package com.stock.management.sales_service.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stock.management.sales_service.client.InventoryClient;
import com.stock.management.sales_service.domain.Sales;
import com.stock.management.sales_service.dto.InventoryResponseEntity;
import com.stock.management.sales_service.dto.ItemsPayload;
import com.stock.management.sales_service.dto.SalesInvoicePayload;
import com.stock.management.sales_service.dto.SalesResponse;
import com.stock.management.sales_service.dto.SalesResponseEntity;
import com.stock.management.sales_service.repository.SalesRepository;
import com.stock.management.sales_service.service.utility.SalesUtility;

@Service
public class SalesService {

	@Autowired
	SalesRepository salesRepository;
	
	@Autowired
	SalesUtility salesUtility;
	
	@Autowired
	InventoryClient inventoryClient;
	
	public SalesResponseEntity getAllSalesInvoice() {
		List<Sales> salesList = salesRepository.findAll();
		List<SalesResponse> salesResponseList = salesUtility.getSalesResponses(salesList);
		SalesResponseEntity salesResponseEntity = new SalesResponseEntity();
		salesResponseEntity.setSalesResponses(salesResponseList);
		return salesResponseEntity;
	}

	public SalesResponseEntity getSalesInvoiceById(Long id) {
		Sales sales = salesRepository.findById(id).orElseThrow();
		List<Sales> salesList = new ArrayList<Sales>();
		salesList.add(sales);
		List<SalesResponse> salesResponseList =  salesUtility.getSalesResponses(salesList);
		SalesResponseEntity salesResponseEntity = new SalesResponseEntity();
		salesResponseEntity.setSalesResponses(salesResponseList);
		return salesResponseEntity;
	}

	public SalesResponseEntity createSalesInvoice(SalesInvoicePayload salesInvoicePayload) {
		List<ItemsPayload> iteams = salesInvoicePayload.getItemsPayloads();
		Long billNumber = salesInvoicePayload.getBillNumber();
		if(billNumber == null) {
			billNumber = getBilNumber();
		}
		List<Sales> salesList = new ArrayList<Sales>();
		for(int i=0;i<iteams.size();i++) {
			Sales sales = salesUtility.getSales(iteams.get(i),billNumber);
			// update stock in inventory
			inventoryClient.updateInventoryStock(sales.getQuantity(), sales.getUnitPrice(), sales.getPartId(),"min");
			salesList.add(sales);
		}
		List<SalesResponse> salesResponseList =  salesUtility.getSalesResponses(salesList);
		SalesResponseEntity salesResponseEntity = new SalesResponseEntity();
		salesResponseEntity.setSalesResponses(salesResponseList);
		return salesResponseEntity;
	}

	private Long getBilNumber() {
		LocalDate currentDate = LocalDate.now();
        String datePart = currentDate.format(DateTimeFormatter.ofPattern("ddyyMM"));

        // Random 4-digit number (1000 - 9999)
        Random random = new Random();
        int randomNumber = random.nextInt(9000) + 1000;

        // Combine date + random number
        String billNumber = datePart + randomNumber;
        return Long.parseLong(billNumber);
	}

}
