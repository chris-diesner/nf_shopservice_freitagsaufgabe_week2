package de.neuefische.model;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private String idOrder;
    private Map<String, Product> productOrderMap = new HashMap<>();
    private OrderStatus orderStatus;

    public Order() {

    }


    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public void setProductOrderMap(Map<String, Product> productOrderMap) {
        this.productOrderMap = productOrderMap;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public Map<String, Product> getProductOrderMap() {
        return productOrderMap;
    }

    public Order(String idOrder, Map<String, Product> productOrderMap, OrderStatus orderStatus) {
        this.idOrder = idOrder;
        this.productOrderMap = productOrderMap;
        this.orderStatus = orderStatus;
    }



    @Override
    public String toString() {
        return "Order{" +
                "idOrder='" + idOrder + '\'' +
                ", productOrderMap=" + productOrderMap +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
