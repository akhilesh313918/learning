package com.cmos.invoice.invoiceapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmos.invoice.invoiceapi.bean.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
