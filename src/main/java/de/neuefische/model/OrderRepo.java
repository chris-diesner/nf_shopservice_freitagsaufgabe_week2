package de.neuefische.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepo {
    private Map<String, Order> orderMap = new HashMap<>();

    public OrderRepo(Map<String, Order> orderMap) {
        this.orderMap = orderMap;
    }


    @Override
    public String toString() {
        return "OrderRepo{" +
                "orderMap=" + orderMap +
                '}';
    }

    public Order getOrderById(String id) throws OrderNotFoundException {
        if (this.orderMap.containsKey(id)) {
            return orderMap.get(id);
        }
        throw new OrderNotFoundException("order with ID " + id + " not found");
    }

    public Map<String, Order> getOrders() {
        return orderMap;
    }

    public OrderRepo() {
    }

    public Order addOrder(Order order) throws InvalidProductException{
        //
        this.orderMap.put(order.getIdOrder(), order);
        return orderMap.get(order.getIdOrder());
    }

    public List<Order> getOrderList() {
        List<Order> orderList = new ArrayList<>();
        for (Order order : orderMap.values()) {
            orderList.add(order);
        }
        return orderList;
    }
}
