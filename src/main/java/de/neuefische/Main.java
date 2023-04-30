package de.neuefische;

import de.neuefische.model.*;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws ProductNotFoundException, OrderNotFoundException, InvalidProductException {

        //Constructors
        Map<String, Product> myProductMap = new HashMap<>();
        ProductRepo myProductRepo = new ProductRepo(myProductMap);
        ShopService myShopService = new ShopService(myProductRepo);

        //create new products
        Product p1 = new Product("1", "Der Planer", 9.99);
        Product p2 = new Product("2", "MadTV", 6.99);
        Product p3 = new Product("3", "Duke Nukem 3D", 8.99);
        Product p4 = new Product("4", "Sid Meyer's Civilization", 11.99);

        //add products to productMap
        myProductMap.put(p1.getIdProduct(), p1);
        myProductMap.put(p2.getIdProduct(), p2);
        myProductMap.put(p3.getIdProduct(), p3);
        myProductMap.put(p4.getIdProduct(), p4);

        Map<String, Product> myOrderMap = new HashMap<>();
        myOrderMap.put(p1.getIdProduct(), p1);
        myOrderMap.put(p4.getIdProduct(), p4);

        Order o1 = new Order("001", myOrderMap, OrderStatus.RECEIVED);

        try {
            myShopService.addOrder(o1);
        } catch (InvalidProductException e) {
            System.out.println(e.getMessage());
        }

        //testing outputs
        System.out.println(myShopService.listProducts());
        System.out.println(myShopService.listOrders());





    }
}