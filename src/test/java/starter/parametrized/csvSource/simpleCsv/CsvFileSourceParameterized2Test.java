package starter.parametrized.csvSource.simpleCsv;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CsvFileSourceParameterized2Test {
    /*
    @CsvSource anotasyonu, parametrized testlerde verileri doğrudan anotasyonun içinde belirtmek için kullanılır.
    Bu yöntem, küçük veri kümeleri için uygun bir yöntemdir ve harici bir CSV dosyasına ihtiyaç duymaz.
    Veri kümesi doğrudan anotasyon içinde tanımlandığından, test kodunun daha taşınabilir olmasını sağlar.
     */
    @ParameterizedTest
    @CsvSource({ "hello, 1", "world, 2", "'happy, testing', 3" })
    void testWithCsvSource(String first, int second) {
        System.out.println("Parameterized test with (String) " + first + " and (int) " + second);
        assertNotNull(first);
        assertNotEquals(0, second);
    }
}
    /*
    @CsvSource({ "hello, 1", "world, 2", "'happy, testing', 3" }) ifadesi,
    parametrized testlere veri sağlamak için kullanılır.
    Her bir veri satırı çift tırnak içinde belirtilir ve virgülle ayrılır.
    Örneğin, "hello, 1" bir veri satırıdır.
    Birden fazla veri satırı varsa, bunlar virgülle ayrılır ve her biri bir test çağrısı için kullanılır.

    testWithCsvSource(String first, int second) metodu, first ve second parametrelerini alır.
    @CsvSource anotasyonunda belirtilen her veri satırı bu metodun argümanları olarak kullanılır.
    assertNotNull(first) ifadesi, first parametresinin null olmadığını kontrol eder.
    assertNotEquals(0, second) ifadesi, second parametresinin 0'a eşit olmadığını kontrol eder.

    Testlerin Çalışması
        İlk veri satırı "hello, 1":

        first = "hello"
        second = 1
        Çıktı: Parameterized test with (String) hello and (int) 1
        Kontroller: assertNotNull("hello") geçer, assertNotEquals(0, 1) geçer.
        İkinci veri satırı "world, 2":

        first = "world"
        second = 2
        Çıktı: Parameterized test with (String) world and (int) 2
        Kontroller: assertNotNull("world") geçer, assertNotEquals(0, 2) geçer.
        Üçüncü veri satırı "'happy, testing', 3":

        first = "happy, testing"
        second = 3
        Çıktı: Parameterized test with (String) happy, testing and (int) 3
        Kontroller: assertNotNull("happy, testing") geçer, assertNotEquals(0, 3) geçer.

        Notlar
        Virgülle Ayrılmış Değerler:
        Eğer değerlerin kendisinde virgül bulunuyorsa, bu değeri tek tırnak içine almanız gerekir.
        Örneğin, "'happy, testing'" ifadesi "happy, testing" stringini temsil eder.
        String to Primitive Type Conversion:
        JUnit 5, String kaynaklarından gelen verileri otomatik olarak uygun türlere dönüştürür.
        Örneğin, "1" stringi otomatik olarak int türüne dönüştürülür.

        Özet
        @CsvSource, verileri doğrudan anotasyon içinde belirtmenize olanak tanır.
        Her bir veri satırı, test metoduna argüman olarak kullanılır.
        Bu yöntem, küçük veri kümeleri için uygundur ve harici bir dosya kullanmayı gerektirmez.

     */