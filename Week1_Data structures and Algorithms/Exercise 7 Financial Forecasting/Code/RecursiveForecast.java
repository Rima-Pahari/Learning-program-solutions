public class RecursiveForecast {
    public static double futureValue(double principal, double rate, int periods) {
        if (periods == 0) {
            return principal;
        }
        return (1 + rate) * futureValue(principal, rate, periods - 1);
    }
}