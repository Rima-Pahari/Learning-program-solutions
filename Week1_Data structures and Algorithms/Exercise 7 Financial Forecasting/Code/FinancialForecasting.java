public class FinancialForecasting {

    public static double[] forecastRevenue(int[] revenue, int windowSize, int k) {
        int n = revenue.length;
        double[] forecast = new double[k];
        
        for (int i = 0; i < k; i++) {
            int start = Math.max(0, n - windowSize + i);
            int end = n + i;
            double sum = 0;
            int count = 0;

            for (int j = start; j < end && j < n; j++) {
                sum += revenue[j];
                count++;
            }
            forecast[i] = sum / count;
        }
        return forecast;
    }

    public static void main(String[] args) {
        int[] revenue = {1000, 1050, 1100, 1200, 1250, 1300}; // 6 months of data
        int windowSize = 3; // Use last 3 months to average
        int k = 2; // Forecast next 2 months

        double[] result = forecastRevenue(revenue, windowSize, k);
        for (double val : result) {
            System.out.printf("%.2f ", val);
        }
    }
}