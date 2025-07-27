public class OptimizedForecast {
    public static double futureValue(double principal, double rate, int periods) {
        return principal * Math.pow(1 + rate, periods);
    }
}
