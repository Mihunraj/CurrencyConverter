// CurrencyConverter.java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("USD", 1.0); // Base currency
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("JPY", 110.0);
        exchangeRates.put("GBP", 0.75);
    }

    public static double convert(String fromCurrency, String toCurrency, double amount) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Invalid currency");
        }
        double baseAmount = amount / exchangeRates.get(fromCurrency);
        return baseAmount * exchangeRates.get(toCurrency);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        System.out.print("From currency (USD, EUR, JPY, GBP): ");
        String fromCurrency = scanner.next().toUpperCase();
        System.out.print("To currency (USD, EUR, JPY, GBP): ");
        String toCurrency = scanner.next().toUpperCase();

        try {
            double convertedAmount = convert(fromCurrency, toCurrency, amount);
            System.out.printf("%.2f %s = %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
