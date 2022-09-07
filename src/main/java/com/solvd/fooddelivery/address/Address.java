package com.solvd.fooddelivery.address;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "address")
@XmlType(propOrder = {"city", "street", "houseNumber"})
public class Address {


    private String city;

    private String street;

    private String houseNumber;
    @XmlElement(required = true)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @XmlElement(required = true)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    @XmlElement(required = true, name = "house")
    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("city='").append(city).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", houseNumber='").append(houseNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
