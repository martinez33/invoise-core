package com.mycompany.invoise.core.service.number;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;

import java.util.List;

//@Service
public class InvoiceNumberService implements InvoiceServiceInterface {

    private static long lastNumber = 0l;
    private InvoiceRepositoryInterface invoiceRepositoryInterface;

    public InvoiceRepositoryInterface getInvoiceRepositoryInterface() {
        return invoiceRepositoryInterface;
    }

    public void setInvoiceRepositoryInterface(InvoiceRepositoryInterface invoiceRepositoryInterface) {
        this.invoiceRepositoryInterface = invoiceRepositoryInterface;
    }

    public Invoice createInvoice(Invoice invoice){
        invoice.setNumber(String.valueOf(++lastNumber));
        invoiceRepositoryInterface.create(invoice);
        return invoice;
    }

    @Override
    public List<Invoice> getInvoiceList() {
        return invoiceRepositoryInterface.list();
    }

    @Override
    public Invoice getInvoiceByNumber(String number) {
        return invoiceRepositoryInterface.getById(number);
    }
}
