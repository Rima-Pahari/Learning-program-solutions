public class Main {
    public static void main(String[] args) {

        // Get the only object available
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        obj1.showMessage();

        // Check whether both instances are same
        if (obj1 == obj2) {
            System.out.println("Both are same instances (Singleton works!)");
        } else {
            System.out.println("Different instances (Singleton failed!)");
        }
    }
}