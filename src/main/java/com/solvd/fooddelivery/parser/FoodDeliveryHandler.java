package com.solvd.fooddelivery.parser;

import com.solvd.fooddelivery.address.Address;
import com.solvd.fooddelivery.delivery.Delivery;
import com.solvd.fooddelivery.person.Courier;
import com.solvd.fooddelivery.person.Director;
import com.solvd.fooddelivery.restaurant.Dish;
import com.solvd.fooddelivery.restaurant.Restaurant;
import com.solvd.fooddelivery.vehicle.Car;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FoodDeliveryHandler extends DefaultHandler {
    private Delivery delivery;
    private Director director;
    private Address address;
    private Car car;
    private Restaurant restaurant;
    private Dish dish;
    private Courier courier;
    private List<Dish> dishes;
    private List<Restaurant> restaurants;
    private List<Courier> couriers;
    private List<String> ingredients;
    private String lastName;
    private String firstName;
    private String name;
    private String ingredient;
    private boolean isCity;
    private boolean isStreet;
    private boolean isHouse;
    private boolean isDateOfBirth;
    private boolean isId;
    private boolean isCarBrand;
    private boolean isPrepareMinutes;
    private boolean isSpicy;
    private boolean isPrice;
    private boolean isName;
    private boolean isCourierList;
    private boolean isCar;
    private boolean isCourier;
    private boolean isAddress;
    private boolean isDirector;
    private boolean isRestaurants;
    private boolean isRestaurant;
    private boolean isDishList;
    private boolean isDish;
    private boolean isIngredient;
    private boolean isCourierType;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "food-delivery":
                delivery = new Delivery();
                break;
            case "address":
                address = new Address();
                isAddress = true;
                break;
            case "courier-list":
                couriers = new ArrayList<>();
                isCourierList = true;
                break;
            case "car":
                car = new Car();
                isCar = true;
                break;
            case "restaurant-list":
                restaurants = new ArrayList<>();
                isRestaurants = true;
                break;
            case "ingredient":
                isIngredient = true;
                break;
            case "ingredient-list":
                ingredients = new ArrayList<>();
                break;
            case "courier":
                courier = new Courier();
                isCourier = true;
                break;
            case "restaurant":
                restaurant = new Restaurant();
                isRestaurant = true;
                break;
            case "dish-list":
                dishes = new ArrayList<>();
                isDishList = true;
                isName = false;
                break;
            case "dish":
                dish = new Dish();
                isDish = true;
                break;
            case "director":
                director = new Director();
                isDirector = true;
                break;
            case "name":
                lastName = attributes.getValue("last");
                firstName = attributes.getValue("first");
                isName = true;
                break;
            case "city":
                isCity = true;
                break;
            case "street":
                isStreet = true;
                break;
            case "house":
                isHouse = true;
                break;
            case "date-of-birth":
                isDateOfBirth = true;
                break;
            case "id":
                isId = true;
                break;
            case "car-brand":
                isCarBrand = true;
                break;
            case "prepare-minutes":
                isPrepareMinutes = true;
                break;
            case "spicy":
                isSpicy = true;
                break;
            case "price":
                isPrice = true;
                break;
            case "courier-type":
                isCourierType = true;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String string = new String(ch, start, length);
        if (isAddress) {
            if (isCity) {
                address.setCity(string);
                isCity = false;
            }
            if (isStreet) {
                address.setStreet(string);
                isStreet = false;
            }
            if (isHouse) {
                address.setHouseNumber(string);
                isHouse = false;
            }
        }
        if (isDirector) {
            if (isName) {
                director.setLastName(lastName);
                director.setFirstName(firstName);
                isName = false;
            }
            if (isDateOfBirth) {
                director.setDateOfBirth(LocalDate.parse(string));
                isDateOfBirth = false;
            }
            if (isId) {
                director.setId(Long.parseLong(string));
                isId = false;
            }
            if (isCar) {
                if (isCarBrand) {
                    car.setBrand(string);
                    isCarBrand = false;
                }
            }
        }
        if (isCourierList) {
            if (isCourier) {
                if (isName) {
                    courier.setLastName(lastName);
                    courier.setFirstName(firstName);
                    isName = false;
                }
                if (isDateOfBirth) {
                    courier.setDateOfBirth(LocalDate.parse(string));
                    isDateOfBirth = false;
                }
                if (isId) {
                    courier.setId(Long.parseLong(string));
                    isId = false;
                }
                if (isCar) {
                    if (isCarBrand) {
                        car.setBrand(string);
                        isCarBrand = false;
                    }
                    courier.setCar(car);
                }
                if (isCourierType) {
                    courier.setDeliveryType(Courier.DeliveryType.valueOf(string.toUpperCase()));
                    isCourierType = false;
                }
            }
        }
        if (isRestaurant) {
            if (isName) {
                name = string;
                isName = false;
            }
        }
        if (isDishList && isDish) {
            if (isName) {
                name = string;
                isName = false;
            }
        }
        if (isIngredient) {
            ingredient = string;
            isIngredient = false;
        }
        if (isPrepareMinutes) {
            dish.setPrepareTimeMinutes(Integer.parseInt(string));
            isPrepareMinutes = false;
        }
        if (isSpicy) {
            dish.setSpicy(Boolean.parseBoolean(string));
            isSpicy = false;
        }
        if (isPrice) {
            dish.setPrice(new BigDecimal(string));
            isPrice = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("address".equals(qName)) {
            delivery.setAddress(address);
            isAddress = false;
            address = null;
        }
        if ("director".equals(qName)) {
            director.setCar(car);
            delivery.setDirector(director);
            isDirector = false;
            isCar = false;
            isDateOfBirth = false;
            isId = false;
            director = null;
            car = null;
            lastName = null;
            firstName = null;
        }
        if (isCourierList && isCourier) {
            if ("courier".equals(qName)) {
                couriers.add(courier);
                isCourier = false;
                isCar = false;
                isDateOfBirth = false;
                lastName = null;
                firstName = null;
                courier = null;
            }
        }
        if ("courier-list".equals(qName)) {
            delivery.setCouriers(couriers);
            isCourierList = false;
            couriers = null;
        }
        if (isRestaurants && isRestaurant && "name".equals(qName)) {
            restaurant.setName(name);
            restaurants.add(restaurant);
            isRestaurant = false;
            name = null;
        }
        if ("restaurant-list".equals(qName)) {
            delivery.setRestaurants(restaurants);
            isRestaurants = false;
            restaurants = null;
        }
        if (isDish && "name".equals(qName)) {
            dish.setName(name);
            dishes.add(dish);
            isDish = false;
            name = null;
        }
        if ("dish-list".equals(qName)) {
            restaurant.setDishes(dishes);
            isRestaurant = false;
            dishes = null;
            restaurant = null;
        }
        if ("ingredient".equals(qName)) {
            ingredients.add(ingredient);
            ingredient = null;
        }
        if ("ingredient-list".equals(qName)) {
            dish.setIngredients(ingredients);
            ingredients = null;
        }
    }

    public Delivery getDelivery() {
        return delivery;
    }
}
