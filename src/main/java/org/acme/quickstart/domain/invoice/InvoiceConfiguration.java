package org.acme.quickstart.domain.invoice;

import io.quarkus.arc.config.ConfigProperties;

/**
 * • VERBATIM: takes the attribute name as it is for the configuration key (e.g. the attribute vatRate has
 * a configuration key called vatRate). Eg: inv.vatRate=10
 * • KEBAB_CASE: hyphenates the attribute name (e.g. the attribute vatRate has a configuration key
 * called vat-rate). Eg: inv.vat-rate=10
 */
@ConfigProperties(prefix = "inv", namingStrategy = ConfigProperties.NamingStrategy.VERBATIM)
public class InvoiceConfiguration {
    public Float vatRate;
    public Boolean allowsDiscount;
    public Float discountRate;
    public String terms;
    public String penalties;
}
