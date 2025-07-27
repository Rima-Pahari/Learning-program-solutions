import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(205, "T-shirt", "Clothing"),
            new Product(307, "Coffee Mug", "Kitchen"),
            new Product(401, "Book", "Stationery")
        };

        // Sorting array for binary search
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        int targetId = 205;

        int linearIndex = LinearSearch.search(products, targetId);
        System.out.println("Linear Search Index: " + linearIndex);
        if (linearIndex != -1) System.out.println(products[linearIndex]);

        int binaryIndex = BinarySearch.search(products, targetId);
        System.out.println("Binary Search Index: " + binaryIndex);
        if (binaryIndex != -1) System.out.println(products[binaryIndex]);
    }
}