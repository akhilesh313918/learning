package com.cmos.invoice.invoiceapi.bean;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Invoice {
	
	@Id
	@Column(name="id")
	private long id;
	private String customername;
	private String customeraddress;
	private String customergstnumber;
	private BigDecimal subtotal;
	private BigDecimal cgst;
	private BigDecimal sgst;
	private BigDecimal igst;
	private BigDecimal total;
	
	
	@OneToMany(mappedBy = "invoice", fetch= FetchType.LAZY, cascade= CascadeType.ALL)
	private List<InvoiceItem> invoiceitems;
	
	
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Invoice(long id, String customername, String customeraddress, String customergstnumber, BigDecimal subtotal,
			BigDecimal cgst, BigDecimal sgst, BigDecimal igst, BigDecimal total, List<InvoiceItem> invoiceitems) {
		super();
		this.id = id;
		this.customername = customername;
		this.customeraddress = customeraddress;
		this.customergstnumber = customergstnumber;
		this.subtotal = subtotal;
		this.cgst = cgst;
		this.sgst = sgst;
		this.igst = igst;
		this.total = total;
		this.invoiceitems = invoiceitems;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCustomername() {
		return customername;
	}


	public void setCustomername(String customername) {
		this.customername = customername;
	}


	public String getCustomeraddress() {
		return customeraddress;
	}


	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}


	public String getCustomergstnumber() {
		return customergstnumber;
	}


	public void setCustomergstnumber(String customergstnumber) {
		this.customergstnumber = customergstnumber;
	}


	public BigDecimal getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}


	public BigDecimal getCgst() {
		return cgst;
	}


	public void setCgst(BigDecimal cgst) {
		this.cgst = cgst;
	}


	public BigDecimal getSgst() {
		return sgst;
	}


	public void setSgst(BigDecimal sgst) {
		this.sgst = sgst;
	}


	public BigDecimal getIgst() {
		return igst;
	}


	public void setIgst(BigDecimal igst) {
		this.igst = igst;
	}


	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	public List<InvoiceItem> getInvoiceitems() {
		return invoiceitems;
	}


	public void setInvoiceitems(List<InvoiceItem> invoiceitems) {
		this.invoiceitems = invoiceitems;
	}


	@Override
	public String toString() {
		return "Invoice [id=" + id + ", customername=" + customername + ", customeraddress=" + customeraddress
				+ ", customergstnumber=" + customergstnumber + ", subtotal=" + subtotal + ", cgst=" + cgst + ", sgst="
				+ sgst + ", igst=" + igst + ", total=" + total + ", invoiceitems=" + invoiceitems + "]";
	}

	
		
}
