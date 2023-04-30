package de.neuefische.model;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {
    Product p1 = new Product("1", "Der Planer", 9.99);
    Product p2 = new Product("2", "MadTV", 6.99);
    Product p3 = new Product("3", "Duke Nukem 3D", 8.99);
    Product p4 = new Product("4", "Sid Meyer's Civilization", 11.99);

    @Test
    void listProducts_returnEmptyForEmptyProductRepo() throws ProductNotFoundException {
        ProductRepo prEmpty = new ProductRepo();
        ShopService shopService = new ShopService(prEmpty);

        assertTrue(shopService.listProducts().equals(""));
    }

    @Test
    void listProducts_returnListIfValid() throws ProductNotFoundException {
        ProductRepo testProductRepo = new ProductRepo();
        testProductRepo.addProduct(p1);
        testProductRepo.addProduct(p2);
        testProductRepo.addProduct(p3);
        testProductRepo.addProduct(p4);
        ShopService testShopService = new ShopService(testProductRepo);

        assertTrue(testShopService.listProducts().equals(
                  "ID: 1 | Der Planer | Price: 9.99\n"
                + "ID: 2 | MadTV | Price: 6.99\n"
                + "ID: 3 | Duke Nukem 3D | Price: 8.99\n"
                + "ID: 4 | Sid Meyer's Civilization | Price: 11.99\n"));

    }

    @Test
    void getProduct_returnEmptyProductIfInputIsInvalid() throws ProductNotFoundException {
        Map<String, Product> testProductMap = new HashMap<>();
        testProductMap.put(p1.getIdProduct(), p1);
        ProductRepo testProductRepo = new ProductRepo(testProductMap);
        ShopService testShopService = new ShopService(testProductRepo);

        assertEquals(new Product(), testShopService.getProduct("invalid input"));
    }

    @Test
    void getProduct_returnProductIfInputIsValid() throws ProductNotFoundException {
        Map<String, Product> testProductMap = new HashMap<>();
        testProductMap.put(p1.getIdProduct(), p1);
        ProductRepo testProductRepo = new ProductRepo(testProductMap);
        ShopService testShopService = new ShopService(testProductRepo);

        assertEquals(p1, testShopService.getProduct(p1.getIdProduct()));
    }

    @Test
    void listOrders_returnEmptyForNoOrders() throws OrderNotFoundException {
        Map<String, Product> testProductMap = new HashMap<>();
        ProductRepo testProductRepo = new ProductRepo(testProductMap);
        ShopService testShopService = new ShopService(testProductRepo);

        assertEquals("", testShopService.listOrders());
    }

    @Test
    void listOrder_returnListOfOrders() throws OrderNotFoundException {
        Map<String, Product> testProductMap = new HashMap<>();
        ProductRepo testProductRepo = new ProductRepo(testProductMap);
        ShopService testShopService = new ShopService(testProductRepo);
        testProductMap.put(p1.getIdProduct(), p1);
        Order testOrder = new Order("001", testProductMap, OrderStatus.RECEIVED);

        try {
            testShopService.addOrder(testOrder);
        } catch (InvalidProductException | OrderNotFoundException e){
            System.out.println(e.getMessage());
        }
        assertThat(testOrder.toString()).contains("Order{idOrder='001', productOrderMap={1=Product{id='1', name='Der Planer', price=9.99}}, orderStatus=RECEIVED}");
    }

    @Test
    void getOrder_returnEmptyOrderForInvalidInput() throws OrderNotFoundException {
        Map<String, Product> testProductMap = new HashMap<>();
        ProductRepo testProductRepo = new ProductRepo(testProductMap);
        ShopService testShopService = new ShopService(testProductRepo);

        //assertThat(new Order(), testShopService.getOrder("nope"));
    }


    @Test
    void addOrder_returnThisOrder() {
        Map<String, Product> testProductMap = new HashMap<>();
        testProductMap.put(p1.getIdProduct(), p1);
        ProductRepo testProductRepo = new ProductRepo(testProductMap);
        ShopService testShopService = new ShopService(testProductRepo);
        Order testOrder = new Order("001", testProductMap, OrderStatus.RECEIVED);

        Order actual = new Order();
        try {
            actual = testShopService.addOrder(testOrder);
        } catch (InvalidProductException e) {
            System.out.println(e.getMessage());
        } catch (OrderNotFoundException e) {
            throw new RuntimeException(e); // unbedingt Nachfragen / Überprüfen
        }

        assertEquals(testOrder, actual);
    }




}