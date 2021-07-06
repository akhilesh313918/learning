package com.cmos.invoice.invoiceapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmos.invoice.invoiceapi.bean.InvoiceItem;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
	
	public List<InvoiceItem> findByInvoiceId(long id);

}
