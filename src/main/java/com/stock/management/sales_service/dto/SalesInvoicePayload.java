package com.stock.management.sales_service.dto;


public class SalesInvoicePayload {

	private Long billNumber;
	private Long shopId;
	private Long partId;
	private Integer quantity;
	private Double unitPrice;
	public Long getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(Long billNumber) {
		this.billNumber = billNumber;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public Long getPartId() {
		return partId;
	}
	public void setPartId(Long partId) {
		this.partId = partId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
}
