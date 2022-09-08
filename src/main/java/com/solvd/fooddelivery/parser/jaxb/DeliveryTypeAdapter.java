package com.solvd.fooddelivery.parser.jaxb;

import com.solvd.fooddelivery.person.Courier;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DeliveryTypeAdapter extends XmlAdapter<String, Courier.DeliveryType> {

    @Override
    public Courier.DeliveryType unmarshal(String s) {
        if (s == null) {
            return null;
        }
        return Courier.DeliveryType.valueOf(s.toUpperCase());
    }

    @Override
    public String marshal(Courier.DeliveryType deliveryType) {
        return String.valueOf(deliveryType);
    }
}
