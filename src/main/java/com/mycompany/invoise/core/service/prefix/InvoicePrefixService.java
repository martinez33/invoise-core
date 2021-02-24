package com.mycompany.invoise.core.service.prefix;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class InvoicePrefixService implements InvoiceServiceInterface {

    @Value("${invoice.lastNumber}")
    private long lastNumber;
    @Value("${invoice.prefix}")
    private String prefix;

    @Autowired
    private InvoiceRepositoryInterface invoiceRepositoryInterface;

    public long getLastNumber() {
        return lastNumber;
    }

    public void setLastNumber(long lastNumber) {
        this.lastNumber = lastNumber;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public InvoiceRepositoryInterface getInvoiceRepositoryInterface() {
        return invoiceRepositoryInterface;
    }

    public void setInvoiceRepositoryInterface(InvoiceRepositoryInterface invoiceRepositoryInterface) {
        this.invoiceRepositoryInterface = invoiceRepositoryInterface;
    }

    public Invoice createInvoice(Invoice invoice){
        invoice.setNumber(String.valueOf(prefix + (++lastNumber)));
        invoiceRepositoryInterface.save(invoice);
        return invoice;
    }

    @Override
    public Iterable<Invoice> getInvoiceList() {
        return invoiceRepositoryInterface.findAll();
    }

    @Override
    public Invoice getInvoiceByNumber(String number) {
        return invoiceRepositoryInterface.findById(number).orElseThrow();
    }
}
