package de.neuefische.model;

public class Product {
    private String idProduct;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.idProduct = id;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + idProduct + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
