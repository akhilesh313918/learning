package com.cmos.invoice.invoiceapi.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InvoiceItem {
	
	@Id
	private long itemid;
	private String productname;
	private String hsncode;
	private int quantity;
	private long price;
	private long total;
	
	@JsonIgnore
	@ManyToOne()
	@MapsId("id")
	private Invoice invoice;

	public InvoiceItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvoiceItem(long itemid, String productname, String hsncode, int quantity, long price, long total,
			Invoice invoice) {
		super();
		this.itemid = itemid;
		this.productname = productname;
		this.hsncode = hsncode;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
		this.invoice = invoice;
	}

	public long getItemid() {
		return itemid;
	}

	public void setItemid(long itemid) {
		this.itemid = itemid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getHsncode() {
		return hsncode;
	}

	public void setHsncode(String hsncode) {
		this.hsncode = hsncode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	

}
