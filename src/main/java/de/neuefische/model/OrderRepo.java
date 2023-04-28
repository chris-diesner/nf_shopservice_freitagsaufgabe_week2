package de.neuefische.model;

import de.neuefische.model.Order;
import de.neuefische.model.OrderNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class OrderRepo {
    private Map<String, Order> orderMap = new HashMap<>();

    public OrderRepo(Map<String, Order> orderMap) {
        this.orderMap = orderMap;
    }

    public Map<String, Order> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<String, Order> orderMap) {
        this.orderMap = orderMap;
    }

    @Override
    public String toString() {
        return "OrderRepo{" +
                "orderMap=" + orderMap +
                '}';
    }

    public Order getById(String id) throws OrderNotFoundException {
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

    public void list() {
        //output
    }

    public void add(){
        //
    }
}
