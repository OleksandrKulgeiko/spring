package com.kulgeiko.spring_prep.c_test.integrationtesting;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by akulgeiko on 7/18/2018.
 */

@Service
public class OrderService {

    public String placeOrders(List<Order> orders) {
        //just a dummy service
        return orders.size() + " orders placed";
    }
}
