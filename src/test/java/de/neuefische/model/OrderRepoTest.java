package de.neuefische.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {

    @Test
    void getOrderById_returnOrderWhenValid() throws OrderNotFoundException, InvalidProductException {
        OrderRepo testOR = new OrderRepo();
        Order o1 = new Order("1", new HashMap<String, Product>(), OrderStatus.RECEIVED);

        assertEquals(testOR.addOrder(o1), testOR.getOrderById(o1.getIdOrder()));
    }

    @Test
    void addOrder_returnOrder() throws InvalidProductException {
        OrderRepo testOR = new OrderRepo();
        Order o1 = new Order("1", new HashMap<String, Product>(), OrderStatus.RECEIVED);

        assertEquals(o1, testOR.addOrder(o1));
    }

}