package starter.parametrized.csvSource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CsvFileSourceParameterizedTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/input.csv")
    void testWithCsvFileSource(String first, int second) {
        System.out.println("Yet another parameterized test with (String) " + first + " and (int) " + second);
        assertNotNull(first);
        assertNotEquals(0, second);
    }
}
/*
@CsvFileSource anotasyonu ile test verilerini herhangi bir dosya uzantısından sağlayabilirsiniz.
Dosyanın uzantısının .csv olması gerekmez, .txt veya başka bir uzantıya sahip dosya kullanabilirsiniz.
Önemli olan, dosyanın içeriğinin CSV formatında olmasıdır (yani, virgülle ayrılmış değerler içermesi).

    "hello", 1
    "world", 2
    "test", 3


@CsvFileSource anotasyonu kullanıldığında, input parametreleri CSV dosyasında satır satır olmalıdır.
Her satır, test metoduna geçilecek parametreleri temsil eder
ve her satırdaki değerler virgülle (veya belirlediğiniz başka bir ayırıcı ile) ayrılır.

Bu dosyada:

İlk satır "hello", 1 test metoduna "hello" ve 1 argümanları olarak geçer.
İkinci satır "world", 2 test metoduna "world" ve 2 argümanları olarak geçer.
Üçüncü satır "test", 3 test metoduna "test" ve 3 argümanları olarak geçer.
 */
