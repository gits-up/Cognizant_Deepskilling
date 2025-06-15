public class FinancialForecast {

    public static double forecastRecursive(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return forecastRecursive(presentValue * (1 + rate), rate, years - 1);
    }

    public static double forecastOptimized(double presentValue, double rate, int years) {
        return presentValue * Math.pow(1 + rate, years);
    }

    public static void main(String[] args) {
        double presentValue = 10000.0;
        double rate = 0.10;
        int years = 5;

        double futureValueRecursive = forecastRecursive(presentValue, rate, years);
        double futureValueOptimized = forecastOptimized(presentValue, rate, years);

        System.out.printf("Future Value (Recursive): Rs. %.2f\n", futureValueRecursive);
        System.out.printf("Future Value (Optimized): Rs. %.2f\n", futureValueOptimized);
    }
}