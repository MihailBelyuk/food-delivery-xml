package com.solvd.fooddelivery.delivery;

import com.solvd.fooddelivery.address.Address;
import com.solvd.fooddelivery.person.Courier;
import com.solvd.fooddelivery.person.Director;
import com.solvd.fooddelivery.restaurant.Restaurant;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement(name = "food-delivery")
@XmlType(propOrder = {"address", "director", "restaurants", "couriers"})
public class Delivery {

    private Address address;
    private Director director;
    private List<Restaurant> restaurants;
    private List<Courier> couriers;

    @XmlElement(name = "address")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @XmlElement
    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @XmlElementWrapper(name = "restaurant-list")
    @XmlElement(name = "restaurant")
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    @XmlElementWrapper(name = "courier-list")
    @XmlElement(name = "courier")
    public List<Courier> getCouriers() {
        return couriers;
    }

    public void setCouriers(List<Courier> couriers) {
        this.couriers = couriers;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Delivery{");
        sb.append("address=").append(address);
        sb.append(", director=").append(director);
        sb.append(", restaurants=").append(restaurants);
        sb.append(", couriers=").append(couriers);
        sb.append('}');
        return sb.toString();
    }
}
