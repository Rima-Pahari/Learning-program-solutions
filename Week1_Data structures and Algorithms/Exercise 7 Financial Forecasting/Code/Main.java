public class Main {
    public static void main(String[] args) {
        double principal = 1000.0;
        double rate = 0.1;
        int periods = 5;

        double recursiveResult = RecursiveForecast.futureValue(principal, rate, periods);
        System.out.printf("Recursive Future Value: %.2f%n", recursiveResult);

        double iterativeResult = IterativeForecast.futureValue(principal, rate, periods);
        System.out.printf("Iterative Future Value: %.2f%n", iterativeResult);

        double optimizedResult = OptimizedForecast.futureValue(principal, rate, periods);
        System.out.printf("Optimized Future Value (Math.pow): %.2f%n", optimizedResult);
    }
}