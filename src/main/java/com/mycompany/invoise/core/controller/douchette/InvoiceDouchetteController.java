package com.mycompany.invoise.core.controller.douchette;

import com.mycompany.invoise.core.controller.InvoiceControllerInterface;
import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;

//@Controller
public class InvoiceDouchetteController implements InvoiceControllerInterface {
    private InvoiceServiceInterface invoiceServiceInterface;

    public InvoiceServiceInterface getInvoiceServiceInterface() {
        return invoiceServiceInterface;
    }

    public void setInvoiceServiceInterface(InvoiceServiceInterface invoiceServiceInterface) {
        this.invoiceServiceInterface = invoiceServiceInterface;
    }

    public String createInvoice(Invoice invoice){
        System.out.println("Usage of a scanner");
        invoice = new Invoice();
        invoice.setCustomerName("Virgin Galactic");
        invoiceServiceInterface.createInvoice(invoice);
        return null;
    }
}
