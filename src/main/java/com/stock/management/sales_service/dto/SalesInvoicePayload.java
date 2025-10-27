package com.stock.management.sales_service.dto;

import java.util.List;

public class SalesInvoicePayload {

	private Long billNumber;
	private List<ItemsPayload> itemsPayloads;

	public List<ItemsPayload> getItemsPayloads() {
		return itemsPayloads;
	}
	public void setItemsPayloads(List<ItemsPayload> itemsPayloads) {
		this.itemsPayloads = itemsPayloads;
	}
	public Long getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(Long billNumber) {
		this.billNumber = billNumber;
	}
		
	
}
