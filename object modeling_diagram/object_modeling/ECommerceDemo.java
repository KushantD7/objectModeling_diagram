package object_modeling;

import java.util.*;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Order {
    int orderId;
    List<Product> products;

    Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    void addProduct(Product product) {
        products.add(product);
    }

    void showOrderDetails() {
        System.out.println("Order #" + orderId + " contains:");
        double total = 0;
        for (Product p : products) {
            System.out.println("- " + p.name + " ($" + p.price + ")");
            total += p.price;
        }
        System.out.println("Total: $" + total);
    }
}

class Customer {
    String name;
    List<Order> orders;

    Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed Order #" + order.orderId);
    }
}

public class ECommerceDemo {
    public static void main(String[] args) {
        // Create products
        Product laptop = new Product("Laptop", 1000);
        Product mouse = new Product("Mouse", 50);
        Product keyboard = new Product("Keyboard", 80);

        // Create customer
        Customer alice = new Customer("Alice");

        // Create order and add products
        Order order1 = new Order(1);
        order1.addProduct(laptop);
        order1.addProduct(mouse);

        // Customer places the order
        alice.placeOrder(order1);

        // Display order details
        order1.showOrderDetails();

        // Another order
        Order order2 = new Order(2);
        order2.addProduct(keyboard);
        alice.placeOrder(order2);
        order2.showOrderDetails();
    }
}

