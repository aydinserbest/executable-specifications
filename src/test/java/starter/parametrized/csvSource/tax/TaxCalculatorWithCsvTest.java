package starter.parametrized.csvSource.tax;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxCalculatorWithCsvTest {
    @ParameterizedTest
    @CsvSource({"10000, 0.1, 1000.0", "25000, 0.25, 6250.0" })
    void calculateTax_ShouldApplyTaxRate(double income, double taxRate, double expectedTax) {
        TaxCalculator calculator = new TaxCalculator();
        assertEquals(expectedTax, calculator.calculateTax(income, taxRate));    }
}

/*
        TaxCalculator Sınıfı:

calculateTax(double income, double taxRate) metodu, verilen gelir ve vergi oranına göre vergiyi hesaplar. Hesaplama basitçe income * taxRate formülüyle yapılır.
Test Sınıfı (TaxCalculatorTest):

calculateTax_ShouldApplyTaxRate metodu, @ParameterizedTest ve @CsvSource anotasyonları kullanılarak parametrized test yapar.
@CsvSource({"10000, 0.1, 1000.0", "25000, 0.25, 6250.0"}) ile belirtilen veriler test metoduna argüman olarak geçilir: gelir (income), vergi oranı (taxRate) ve beklenen vergi (expectedTax).
assertEquals(expectedTax, calculator.calculateTax(income, taxRate)) ifadesi, calculateTax metodunun doğru sonuç verip vermediğini kontrol eder ve beklenen değerle karşılaştırır.
Test Çalışması
Bu test çalıştırıldığında:

İlk veri satırı için (10000, 0.1, 1000.0):

Gelir: 10000
Vergi Oranı: 0.1
Beklenen Vergi: 1000.0
calculateTax(10000, 0.1) sonucu 1000.0 olmalıdır, bu yüzden test geçer.
İkinci veri satırı için (25000, 0.25, 6250.0):

Gelir: 25000
Vergi Oranı: 0.25
Beklenen Vergi: 6250.0
calculateTax(25000, 0.25) sonucu 6250.0 olmalıdır, bu yüzden test geçer.

 */

