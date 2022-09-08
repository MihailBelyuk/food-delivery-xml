package com.solvd.fooddelivery.restaurant;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "restaurant")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"name", "dishes"})
public class Restaurant {

    @XmlElement
    private String name;
    @XmlElementWrapper(name = "dish-list")
    @XmlElement(name = "dish")
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

