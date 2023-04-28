package de.neuefische.model;

import de.neuefische.model.OrderRepo;
import de.neuefische.model.ProductRepo;

public class ShopService {
    private ProductRepo myProductRepo = new ProductRepo();
    private OrderRepo myOrderRepo = new OrderRepo();

    public ProductRepo getMyProductRepo() {
        return myProductRepo;
    }

    public void setMyProductRepo(ProductRepo myProductRepo) {
        this.myProductRepo = myProductRepo;
    }

    public OrderRepo getMyOrderRepo() {
        return myOrderRepo;
    }

    public void setMyOrderRepo(OrderRepo myOrderRepo) {
        this.myOrderRepo = myOrderRepo;
    }

    public ShopService(ProductRepo myProductRepo, OrderRepo myOrderRepo) {
        this.myProductRepo = myProductRepo;
        this.myOrderRepo = myOrderRepo;
    }

    public ShopService() {
    }

    @Override
    public String toString() {
        return "ShopService{" +
                "myProductRepo=" + myProductRepo +
                ", myOrderRepo=" + myOrderRepo +
                '}';
    }

    public void getProduct() {

    }

    public void listProducts() {

    }

    public void addOrder() {

    }

    public void getOrder() {

    }

    public void listOrders() {

    }


}
