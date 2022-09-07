package com.solvd.fooddelivery.parser;

import com.solvd.fooddelivery.delivery.Delivery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class FoodDeliverySaxParser implements IParse {

    private static final Logger LOGGER = LogManager.getLogger(FoodDeliverySaxParser.class);

    @Override
    public Delivery parse(String filePath) {
        Delivery delivery = null;
        try {
            FoodDeliveryHandler deliveryHandler = new FoodDeliveryHandler();
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(deliveryHandler);
            xmlReader.parse(filePath);
            delivery = deliveryHandler.getDelivery();
        } catch (SAXException | IOException | ParserConfigurationException e) {
            LOGGER.error("Failed to parse XML.");
        }
        return delivery;
    }
}
