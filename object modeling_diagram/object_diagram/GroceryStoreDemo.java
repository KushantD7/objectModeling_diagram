import java.util.*;

class Product {
    String name;
    double quantity;
    double pricePerUnit;

    Product(String name, double quantity, double pricePerUnit) {
        this.name = name;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    double getTotalPrice() {
        return quantity * pricePerUnit;
    }
}

class Customer {
    String name;
    List<Product> products;

    Customer(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    void addProduct(Product product) {
        products.add(product);
    }
}

class BillGenerator {
    void generateBill(Customer customer) {
        double total = 0;
        System.out.println("Bill for " + customer.name + ":");
        for (Product p : customer.products) {
            double price = p.getTotalPrice();
            System.out.println(p.name + " (" + p.quantity + " units at $" + p.pricePerUnit + " each) = $" + price);
            total += price;
        }
        System.out.println("Total: $" + total);
    }
}

public class GroceryStoreDemo {
    public static void main(String[] args) {
        // Create customer and products
        Customer alice = new Customer("Alice");
        alice.addProduct(new Product("Apples", 2, 3));
        alice.addProduct(new Product("Milk", 1, 2));

        // Generate bill
        BillGenerator billGenerator = new BillGenerator();
        billGenerator.generateBill(alice);
    }
}
