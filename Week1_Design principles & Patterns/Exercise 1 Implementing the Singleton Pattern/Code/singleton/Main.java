package singleton;

public class Main {
    public static void main(String[] args) {
        // Step 4: Test the Singleton

        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");

        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");

        // Check if both logger1 and logger2 refer to the same object
        if (logger1 == logger2) {
            System.out.println("Only one instance of Logger is used.");
        } else {
            System.out.println("Different Logger instances exist!");
        }
    }
}