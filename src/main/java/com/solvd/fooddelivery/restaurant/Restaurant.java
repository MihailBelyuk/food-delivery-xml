package com.solvd.fooddelivery.restaurant;

import java.util.List;

public class Restaurant {

    private String name;
    private List<Dish> dishes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Restaurant{");
        sb.append("name='").append(name).append('\'');
        sb.append(", dishes=").append(dishes);
        sb.append('}');
        return sb.toString();
    }
}

