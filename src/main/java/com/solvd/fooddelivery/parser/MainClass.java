package com.solvd.fooddelivery.parser;

import com.solvd.fooddelivery.delivery.Delivery;
import com.solvd.fooddelivery.parser.jackson.FoodDeliveryJsonParser;
import com.solvd.fooddelivery.parser.jaxb.FoodDeliveryJaxbParser;
import com.solvd.fooddelivery.parser.sax.FoodDeliverySaxParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainClass {

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class);
    private static final String FOOD_DELIVERY_XML_PATH = "src/main/resources/fooddelivery.xml";
    private static final String FOOD_DELIVERY_JSON_PATH = "src/main/resources/fooddelivery.json";

    public static void main(String[] args) {
        FoodDeliverySaxParser saxParser = new FoodDeliverySaxParser();
        Delivery delivery1 = saxParser.parse(FOOD_DELIVERY_XML_PATH);
        LOGGER.info("SAX-" + delivery1);

        FoodDeliveryJaxbParser jaxbParser = new FoodDeliveryJaxbParser();
        Delivery delivery2 = jaxbParser.parse(FOOD_DELIVERY_XML_PATH);
        LOGGER.info("JaxB-" + delivery2);

        FoodDeliveryJsonParser jsonParser = new FoodDeliveryJsonParser();
        Delivery delivery3 = jsonParser.parse(FOOD_DELIVERY_JSON_PATH);
        LOGGER.info("Jackson-" + delivery3);
    }
}
