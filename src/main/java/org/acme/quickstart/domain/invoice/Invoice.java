package org.acme.quickstart.domain.invoice;

import org.eclipse.microprofile.config.inject.ConfigProperty;

public class Invoice {
    Float subtotal;
    @ConfigProperty(name = "invoice.vatRate2", defaultValue = "10")
    Float vatRate;
    Float vatAmount;

    public Float getVatRate() {
        return vatRate;
    }
}
