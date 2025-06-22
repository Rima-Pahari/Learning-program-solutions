package singleton;

public class Logger {
    // Step 2: Private static instance
    private static Logger instance;

    // Step 2: Private constructor
    private Logger() {
        System.out.println("Logger Initialized");
    }

    // Step 2 & 3: Public static method to get the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger(); // Lazy initialization
        }
        return instance;
    }

    // Example log method
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}