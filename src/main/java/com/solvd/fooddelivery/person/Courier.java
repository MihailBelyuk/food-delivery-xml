package com.solvd.fooddelivery.person;

import com.solvd.fooddelivery.vehicle.Car;

import java.time.LocalDate;

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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
