package com.solvd.fooddelivery.parser;

import com.solvd.fooddelivery.delivery.Delivery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainClass {

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class);
    private static final String FOOD_DELIVERY_XML_PATH = "src/fooddelivery.xml";

    public static void main(String[] args) {
        FoodDeliverySaxParser parser = new FoodDeliverySaxParser();
        Delivery delivery = parser.parse(FOOD_DELIVERY_XML_PATH);
        LOGGER.info(delivery);
    }
}
