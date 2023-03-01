package org.acme.quickstart.domain.computer;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Computer {

    private String brand;
    @NotBlank
    @Size(min = 4)
    @Max(6)
    private String serialNumber;

    public Computer(){}

    public Computer(String brand, String serialNumber) {
        this.brand = brand;
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
