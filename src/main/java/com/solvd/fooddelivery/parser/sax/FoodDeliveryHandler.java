package com.solvd.fooddelivery.parser.sax;

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

    private static final String ADDRESS = "address";
    private static final String FOOD_DELIVERY = "food-delivery";
    private static final String COURIER_LIST = "courier-list";
    private static final String CAR = "car";
    private static final String RESTAURANT_LIST = "restaurant-list";
    private static final String INGREDIENT = "ingredient";
    private static final String INGREDIENT_LIST = "ingredient-list";
    private static final String COURIER = "courier";
    private static final String RESTAURANT = "restaurant";
    private static final String DISH_LIST = "dish-list";
    private static final String DISH = "dish";
    private static final String DIRECTOR = "director";
    private static final String NAME = "name";
    private static final String CITY = "city";
    private static final String STREET = "street";
    private static final String HOUSE = "house";
    private static final String DATE_OF_BIRTH = "date-of-birth";
    private static final String ID = "id";
    private static final String CAR_BRAND = "car-brand";
    private static final String PREPARE_MINUTES = "prepare-minutes";
    private static final String SPICY = "spicy";
    private static final String PRICE = "price";
    private static final String COURIER_TYPE = "delivery-type";
    private static final String LAST_NAME_ATTR = "last-name";
    private static final String FIRST_NAME_ATTR = "first-name";

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
    private boolean isDeliveryType;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case FOOD_DELIVERY:
                delivery = new Delivery();
                break;
            case ADDRESS:
                address = new Address();
                isAddress = true;
                break;
            case COURIER_LIST:
                couriers = new ArrayList<>();
                isCourierList = true;
                break;
            case CAR:
                car = new Car();
                isCar = true;
                break;
            case RESTAURANT_LIST:
                restaurants = new ArrayList<>();
                isRestaurants = true;
                break;
            case INGREDIENT:
                isIngredient = true;
                break;
            case INGREDIENT_LIST:
                ingredients = new ArrayList<>();
                break;
            case COURIER:
                courier = new Courier();
                lastName = attributes.getValue(LAST_NAME_ATTR);
                firstName = attributes.getValue(FIRST_NAME_ATTR);
                isCourier = true;
                break;
            case RESTAURANT:
                restaurant = new Restaurant();
                isRestaurant = true;
                break;
            case DISH_LIST:
                dishes = new ArrayList<>();
                isDishList = true;
                isName = false;
                break;
            case DISH:
                dish = new Dish();
                isDish = true;
                break;
            case DIRECTOR:
                director = new Director();
                lastName = attributes.getValue(LAST_NAME_ATTR);
                firstName = attributes.getValue(FIRST_NAME_ATTR);
                isDirector = true;
                break;
            case CITY:
                isCity = true;
                break;
            case STREET:
                isStreet = true;
                break;
            case HOUSE:
                isHouse = true;
                break;
            case DATE_OF_BIRTH:
                isDateOfBirth = true;
                break;
            case ID:
                isId = true;
                break;
            case CAR_BRAND:
                isCarBrand = true;
                break;
            case PREPARE_MINUTES:
                isPrepareMinutes = true;
                break;
            case NAME:
                isName = true;
                break;
            case SPICY:
                isSpicy = true;
                break;
            case PRICE:
                isPrice = true;
                break;
            case COURIER_TYPE:
                isDeliveryType = true;
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
                address.setHouseNumber(Integer.parseInt(string));
                isHouse = false;
            }
        }
        if (isDirector) {
            director.setLastName(lastName);
            director.setFirstName(firstName);
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
                courier.setLastName(lastName);
                courier.setFirstName(firstName);
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
                if (isDeliveryType) {
                    courier.setDeliveryType(Courier.DeliveryType.valueOf(string.toUpperCase()));
                    isDeliveryType = false;
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
        if (ADDRESS.equals(qName)) {
            delivery.setAddress(address);
            isAddress = false;
            address = null;
        }
        if (DIRECTOR.equals(qName)) {
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
            if (COURIER.equals(qName)) {
                couriers.add(courier);
                isCourier = false;
                isCar = false;
                isDateOfBirth = false;
                lastName = null;
                firstName = null;
                courier = null;
            }
        }
        if (COURIER_LIST.equals(qName)) {
            delivery.setCouriers(couriers);
            isCourierList = false;
            couriers = null;
        }
        if (isRestaurants && isRestaurant && NAME.equals(qName)) {
            restaurant.setName(name);
            restaurants.add(restaurant);
            isRestaurant = false;
            name = null;
        }
        if (RESTAURANT_LIST.equals(qName)) {
            delivery.setRestaurants(restaurants);
            isRestaurants = false;
            restaurants = null;
        }
        if (isDish && NAME.equals(qName)) {
            dish.setName(name);
            dishes.add(dish);
            isDish = false;
            name = null;
        }
        if (DISH_LIST.equals(qName)) {
            restaurant.setDishes(dishes);
            isRestaurant = false;
            dishes = null;
            restaurant = null;
        }
        if (INGREDIENT.equals(qName)) {
            ingredients.add(ingredient);
            ingredient = null;
        }
        if (INGREDIENT_LIST.equals(qName)) {
            dish.setIngredients(ingredients);
            ingredients = null;
        }
    }

    public Delivery getDelivery() {
        return delivery;
    }
}
