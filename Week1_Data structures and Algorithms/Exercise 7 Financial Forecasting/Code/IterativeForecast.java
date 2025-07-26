public class IterativeForecast {
    public static double futureValue(double principal, double rate, int periods) {
        double result = principal;
        for (int i = 0; i < periods; i++) {
            result *= (1 + rate);
        }
        return result;
    }
}