// Singleton class
public class Singleton {

    // Step 1: Create a private static instance of the same class
    private static Singleton instance;

    // Step 2: Make the constructor private so that this class cannot be instantiated from outside
    private Singleton() {
        System.out.println("Singleton Instance Created");
    }

    // Step 3: Provide a public static method to return the same instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton(); // Lazy initialization
        }
        return instance;
    }

    // Sample method
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}