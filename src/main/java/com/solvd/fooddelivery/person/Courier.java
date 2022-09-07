package com.solvd.fooddelivery.person;

import com.solvd.fooddelivery.parser.LocalDateAdapter;
import com.solvd.fooddelivery.vehicle.Car;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlRootElement(name = "courier")
@XmlType(propOrder = {"firstName", "lastName", "dateOfBirth", "deliveryType", "id", "car"})
public class Courier {

    private Car car;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private DeliveryType deliveryType;
    private long id;

    public enum DeliveryType {
        CAR("car"),
        BICYCLE("bicycle"),
        ON_FOOT("on foot");


        private final String displayName;

        DeliveryType(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    @XmlElement
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @XmlAttribute(name = "first")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlAttribute(name = "last")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement(name = "date-of-birth")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @XmlElement
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlElement(name = "delivery-type")
    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Courier{");
        sb.append("car=").append(car);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", id=").append(id);
        sb.append(", deliveryType=").append(deliveryType);
        sb.append('}');
        return sb.toString();
    }
}
