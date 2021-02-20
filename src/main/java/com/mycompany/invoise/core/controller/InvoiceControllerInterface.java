package com.mycompany.invoise.core.controller;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;

public interface InvoiceControllerInterface {

    void setInvoiceServiceInterface(InvoiceServiceInterface invoiceServiceInterface);
    String createInvoice(Invoice invoice);
}
