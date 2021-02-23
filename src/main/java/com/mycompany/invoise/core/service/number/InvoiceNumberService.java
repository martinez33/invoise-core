package com.mycompany.invoise.core.service.number;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceNumberService implements InvoiceServiceInterface {

    @Autowired
    private InvoiceRepositoryInterface invoiceRepositoryInterface;

    public InvoiceRepositoryInterface getInvoiceRepositoryInterface() {
        return invoiceRepositoryInterface;
    }

    public void setInvoiceRepositoryInterface(InvoiceRepositoryInterface invoiceRepositoryInterface) {
        this.invoiceRepositoryInterface = invoiceRepositoryInterface;
    }

    public Invoice createInvoice(Invoice invoice){
        return invoiceRepositoryInterface.create(invoice);
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
