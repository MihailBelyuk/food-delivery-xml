package com.solvd.fooddelivery.parser;

import com.solvd.fooddelivery.delivery.Delivery;

public interface IParse {

    Delivery parse (String filePath);

}
