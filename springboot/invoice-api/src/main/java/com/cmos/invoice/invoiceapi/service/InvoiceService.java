package com.cmos.invoice.invoiceapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cmos.invoice.invoiceapi.bean.Invoice;
import com.cmos.invoice.invoiceapi.repo.InvoiceRepository;

public class InvoiceService {
	
	@Autowired
	private InvoiceRepository repo;
	
	public List<Invoice> getAllInvoices(){
		return repo.findAll();
	}

}
