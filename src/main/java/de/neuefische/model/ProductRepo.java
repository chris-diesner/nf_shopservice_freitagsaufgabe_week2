package de.neuefische.model;

import de.neuefische.model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepo {
    Map<String, Product> productMap = new HashMap<>();


    public Map<String, Product> getProductMap() {
        return productMap;
    }

    public void addProduct(Product product) {
        productMap.put(product.getIdProduct(), product);
    }

    public void setProductMap(Map<String, Product> productMap) {
        this.productMap = productMap;
    }

    public void list() {
        //Output of product list
        productMap.toString();
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "productMap=" + productMap +
                '}';
    }
}
