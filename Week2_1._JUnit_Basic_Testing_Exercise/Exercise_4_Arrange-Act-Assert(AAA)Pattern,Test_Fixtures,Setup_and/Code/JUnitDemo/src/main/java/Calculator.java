public class Calculator {

    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to subtract two integers
    public int subtract(int a, int b) {
        return a - b;
    }

    // Main method to run the calculator directly
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        int sum = calc.add(5, 3);
        int diff = calc.subtract(10, 4);

        System.out.println("Addition (5 + 3) = " + sum);
        System.out.println("Subtraction (10 - 4) = " + diff);
    }
}
