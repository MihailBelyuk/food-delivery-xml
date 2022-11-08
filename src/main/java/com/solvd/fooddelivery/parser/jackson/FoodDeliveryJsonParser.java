package com.solvd.fooddelivery.parser.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.solvd.fooddelivery.delivery.Delivery;
import com.solvd.fooddelivery.parser.IParse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;

public class FoodDeliveryJsonParser implements IParse {

    private static final Logger LOGGER = LogManager.getLogger(FoodDeliveryJsonParser.class);

    @Override
    public Delivery parse(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Delivery delivery = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            delivery = objectMapper.readValue(fileInputStream, Delivery.class);
        } catch (IOException e) {
            LOGGER.error("Failed to parse JSON.");
        }
        return delivery;
    }
}
