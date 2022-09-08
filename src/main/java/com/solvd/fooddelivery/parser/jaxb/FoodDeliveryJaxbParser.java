package com.solvd.fooddelivery.parser.jaxb;

import com.solvd.fooddelivery.delivery.Delivery;
import com.solvd.fooddelivery.parser.IParse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;

public class FoodDeliveryJaxbParser implements IParse {

    private static final Logger LOGGER = LogManager.getLogger(FoodDeliveryJaxbParser.class);

    @Override
    public Delivery parse(String filePath) {
        Delivery delivery = null;
        try {
            FileReader fileReader = new FileReader(filePath);
            JAXBContext context = JAXBContext.newInstance(Delivery.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            delivery = (Delivery) unmarshaller.unmarshal(fileReader);
        } catch (JAXBException | IOException e) {
            LOGGER.error("Failed to parse xml.");
        }
        return delivery;
    }
}
