package starter.parametrized.csvSource.addresse;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
//Test sınıfı, AddressValidator sınıfının validate metodunu, bir CSV dosyasından sağlanan verilerle test eder.

public class AddressValidatorTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/addressValidation.csv", numLinesToSkip = 1)
    void validateAddress_ReturnsCorrectResult(String address, String zipCode, boolean isValid) {
        AddressValidator validator = new AddressValidator();
        assertEquals(isValid, validator.validate(address, zipCode));
    }
}
    /*
    @CsvFileSource anotasyonunda kullanılan numLinesToSkip parametresi,
    CSV dosyasının başındaki belirli sayıda satırın test verisi olarak kullanılmadan atlanmasını sağlar.
    Bu genellikle CSV dosyasının başlık satırını atlamak için kullanılır.
    Başlık satırı, sütun adlarını veya açıklayıcı bilgileri içerir ve test verisi olarak kullanılmamalıdır.

Örnek
Örneğin, aşağıdaki gibi bir CSV dosyanız olduğunu düşünelim:


# Address, Zip Code, Expected Result
123 Main St, 90210, true
42 Unknown Road, ABCDE, false

Bu dosyanın ilk satırı başlık satırıdır ve numLinesToSkip = 1 kullanarak bu satırı atlayabilirsiniz.

Açıklama
CSV Dosyası:

İlk satır başlık satırıdır: # Address, Zip Code, Expected Result
İkinci satırdan itibaren veri satırları başlar.
@CsvFileSource Anotasyonu:

resources = "/addressValidation.csv": addressValidation.csv dosyasını kaynak olarak kullanır.
numLinesToSkip = 1: İlk satırı atlar, çünkü bu satır başlık satırıdır ve veri olarak kullanılmamalıdır.
     */

/*
validateAddress_ReturnsCorrectResult metodu,
@ParameterizedTest ve @CsvFileSource anotasyonları kullanılarak parametrized test yapar.
@CsvFileSource(resources = "/addressValidation.csv", numLinesToSkip = 1) ile
belirtilen CSV dosyasından veriler alınır.
numLinesToSkip = 1, dosyanın ilk satırının (başlık satırı) atlanacağını belirtir.
assertEquals(isValid, validator.validate(address, zipCode)) ifadesi,
validate metodunun doğru sonuç verip vermediğini kontrol eder ve beklenen değerle karşılaştırır.
 */
/*
Test Çalışması
Bu test çalıştırıldığında, CSV dosyasındaki her satır için validate metodunun doğru çalışıp çalışmadığı kontrol edilir:

İlk veri satırı (123 Main St, 90210, true):

Adres: 123 Main St
Posta Kodu: 90210
Beklenen Sonuç: true
validator.validate("123 Main St", "90210") sonucu true olmalıdır, bu yüzden test geçer.
İkinci veri satırı (42 Unknown Road, ABCDE, false):

Adres: 42 Unknown Road
Posta Kodu: ABCDE
Beklenen Sonuç: false
validator.validate("42 Unknown Road", "ABCDE") sonucu false olmalıdır, bu yüzden test geçer.
Bu örnek, JUnit 5 ile parametrized test yapmanın ve adres doğrulama işlemi yapan
basit bir yardımcı sınıf (AddressValidator) yazmanın temel bir örneğidir
 */
