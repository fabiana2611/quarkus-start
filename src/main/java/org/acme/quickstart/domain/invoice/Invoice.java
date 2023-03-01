package org.acme.quickstart.domain.invoice;

import org.eclipse.microprofile.config.inject.ConfigProperty;

public class Invoice {
    Float subtotal;
    @ConfigProperty(name = "app.invoice.vatRate", defaultValue = "10")
    Float vatRate;
    Float vatAmount;
    Float total;
    Boolean allowsDiscount;
    Float discountRate;
    String terms;
    String penalties;
}
