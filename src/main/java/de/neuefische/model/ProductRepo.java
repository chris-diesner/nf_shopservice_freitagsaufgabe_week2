package de.neuefische.model;

import de.neuefische.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductRepo {
    private ArrayList<Product> productMap = new ArrayList<>();

    public ArrayList<Product> getProductMap() {
        return productMap;
    }

    public void setProductMap(ArrayList<Product> productMap) {
        this.productMap = productMap;
    }

    public Product getById(String id) throws ProductNotFoundException {
        for (Product product : this.productMap) {
            if (product.getId().equals(id))
                return product;
        }
        throw new ProductNotFoundException("product with ID " + id + " not found");
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "productMap=" + productMap +
                '}';
    }

    public Product addProduct(Product product) {
        this.productMap.add(product);
        return product;
    }
}
