package de.neuefische;

import de.neuefische.model.Product;
import de.neuefische.model.ProductRepo;
import org.junit.jupiter.api.Test;

class ProductRepoTest {

    Product p1 = new Product("1", "Der Planer", 9.99);
    Product p2 = new Product("2", "MadTV", 6.99);
    Product p3 = new Product("3", "Duke Nukem 3D", 8.99);
    Product p4 = new Product("4", "Sid Meyer's Civilization", 11.99);

    @Test
    void listAllProducts() {
        ProductRepo testRepo = new ProductRepo();
        testRepo.addProduct(p1);

    }
}