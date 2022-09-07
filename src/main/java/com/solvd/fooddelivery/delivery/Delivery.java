package com.solvd.fooddelivery.delivery;

import com.solvd.fooddelivery.address.Address;
import com.solvd.fooddelivery.person.Courier;
import com.solvd.fooddelivery.person.Director;
import com.solvd.fooddelivery.restaurant.Restaurant;

import java.util.List;

public class Delivery {

    private Address address;
    private Director director;
    private List<Restaurant> restaurants;
    private List<Courier> couriers;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

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
