package com.stock.management.sales_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.management.sales_service.domain.Sales;
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
		Sales sales = salesUtility.getSales(salesInvoicePayload,null);
		sales = salesRepository.save(sales);
		List<Sales> salesList = new ArrayList<Sales>();
		salesList.add(sales);
		List<SalesResponse> salesResponseList =  salesUtility.getSalesResponses(salesList);
		SalesResponseEntity salesResponseEntity = new SalesResponseEntity();
		salesResponseEntity.setSalesResponses(salesResponseList);
		return salesResponseEntity;
	}

	public SalesResponseEntity updateSalesInvoice(SalesInvoicePayload invoicePayload, Long id) {
		Sales sales = salesUtility.getSales(invoicePayload,id);
		sales = salesRepository.save(sales);
		List<Sales> salesList = new ArrayList<Sales>();
		salesList.add(sales);
		List<SalesResponse> salesResponseList =  salesUtility.getSalesResponses(salesList);
		SalesResponseEntity salesResponseEntity = new SalesResponseEntity();
		salesResponseEntity.setSalesResponses(salesResponseList);
		return salesResponseEntity;
	}

}
