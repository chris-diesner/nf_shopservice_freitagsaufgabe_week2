package de.neuefische.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepo {
    private Map<String, Product> productMap = new HashMap<>();

    public ProductRepo() {
    }

    public ProductRepo(Map<String, Product> productMap) {
        this.productMap = productMap;
    }

    public Product getProductById(String idProduct) throws ProductNotFoundException {
        if (productMap.containsKey(idProduct))
            return productMap.get(idProduct);

        throw new ProductNotFoundException("product with ID " + idProduct + " not found");
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "productMap=" + productMap +
                '}';
    }

    public Product addProduct(Product product) {
        this.productMap.put(product.getIdProduct(), product);
        return productMap.get(product.getIdProduct());
    }

    public List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();
        for(Product products : productMap.values()) {
            productList.add(products);
        }
        return productList;
    }
}
