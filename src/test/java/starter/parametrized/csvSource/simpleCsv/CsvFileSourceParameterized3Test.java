package starter.parametrized.csvSource.simpleCsv;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CsvFileSourceParameterized3Test {
    /*
    @CsvSource anotasyonu, array metodundan veri sağlama yöntemine benzer şekilde çalışır,
    ancak veriler doğrudan anotasyon içinde tanımlanır.
    Bu, verileri bir metodun dışında doğrudan kodun içinde belirlemenize olanak tanır.
    Şimdi, array metodundan veri sağlama ve @CsvSource kullanma arasındaki benzerlikleri ve farkları açıklayalım.

Array Metodundan Veri Sağlama
Daha önceki örnekte, array'den veri sağlayan bir metot kullanmıştık:
     */
    @ParameterizedTest
    @MethodSource("arrayProvider")
    void testWithStreamArray(String argument) {
        System.out.println("Parameterized test with (String) argument: " + argument);
        assertNotNull(argument);
    }
        //with stream
    static Stream<String> arrayProvider() {
        return Stream.of("Hello", "JUnit", "5");
    }
    @ParameterizedTest
    @MethodSource("arrayProvider2")
    void testWithPlainArray(String argument) {
        System.out.println("Parameterized test with (String) argument: " + argument);
        assertNotNull(argument);
    }
        //with plain array
    static String[] arrayProvider2() {
        return new String[]{"Hello", "JUnit", "5"};
    }

}
    /*
    static String[] arrayProvider() { return new String[]{"Hello", "JUnit", "5"}; } örneğinde Stream kullanılmamış.
    Bu örnek, sadece bir dizi (array) döndürüyor. Ancak, Stream kullanmak da mümkün ve bazen tercih edilebilir.
     */