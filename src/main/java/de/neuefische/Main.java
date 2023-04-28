package de.neuefische;

import de.neuefische.model.Product;
import de.neuefische.model.ProductRepo;

public class Main {
    public static void main(String[] args) {

        //create new products
        Product p1 = new Product("1", "Der Planer", 9.99);
        Product p2 = new Product("2", "MadTV", 6.99);
        Product p3 = new Product("3", "Duke Nukem 3D", 8.99);
        Product p4 = new Product("4", "Sid Meyer's Civilization", 11.99);

        //add products to ProductRepo
        ProductRepo myProductRepo = new ProductRepo();
        myProductRepo.addProduct(p1);
        myProductRepo.addProduct(p2);
        myProductRepo.addProduct(p3);
        myProductRepo.addProduct(p4);

        //print list of all products
        System.out.println(myProductRepo.getProductMap());
    }
}