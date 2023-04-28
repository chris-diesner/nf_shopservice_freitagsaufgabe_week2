package de.neuefische.model;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private String idOrder;
    private Map<String, Product> productOrderMap = new HashMap<>();

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public Map<String, Product> getProductOrderMap() {
        return productOrderMap;
    }

    public void setProductOrderMap(Map<String, Product> productOrderMap) {
        this.productOrderMap = productOrderMap;
    }

    public Order(String id, Map<String, Product> productOrderMap) {
        this.idOrder = id;
        this.productOrderMap = productOrderMap;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + idOrder + '\'' +
                ", productOrderMap=" + productOrderMap +
                '}';
    }
}