package de.neuefische.model;

import java.util.NoSuchElementException;

public class ShopService {
    private ProductRepo myProductRepo;
    private OrderRepo myOrderRepo = new OrderRepo();

    public ShopService(ProductRepo myProductRepo) {
        this.myProductRepo = myProductRepo;
        this.myOrderRepo = myOrderRepo;
    }

    public Order addOrder(Order order) throws InvalidProductException, OrderNotFoundException {
        myOrderRepo.addOrder(order);
        return myOrderRepo.getOrderById(order.getIdOrder());
    }


    public String listProducts() throws ProductNotFoundException {
        String outputProductList = "";
        for (Product product : myProductRepo.getProductList()) {
            myProductRepo.getProductById(product.getIdProduct());
            outputProductList = outputProductList + "ID: "
                    + product.getIdProduct() + " | "
                    + product.getName() + " | Price: "
                    + product.getPrice() + "\n";
        }
        return outputProductList;
    }

    public Product getProduct(String productId) throws ProductNotFoundException {
        try {
            return myProductRepo.getProductById(productId);
        } catch (ProductNotFoundException e) {
            return new Product();
        }

    }

    public String listOrders() throws OrderNotFoundException {
        String outputOrderList = "";
        for (Order order : myOrderRepo.getOrderList()){
            myOrderRepo.getOrderById(order.getIdOrder());
            outputOrderList = outputOrderList + order.toString() + "\n";
        }
        return outputOrderList;
    }

    public Order getOrder(String orderID){
        try {
            return myOrderRepo.getOrderById(orderID);
        } catch (NoSuchElementException | OrderNotFoundException e){
            return new Order();
        }
    }
}