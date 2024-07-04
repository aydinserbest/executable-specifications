package starter.parametrized.csvSource.tax;

public class TaxCalculator {
    // Gelir ve vergi oranına göre vergiyi hesaplayan metot
    public double calculateTax(double income, double taxRate) {
        return income * taxRate;
    }
}
