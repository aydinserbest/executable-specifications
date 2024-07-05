package starter.parametrized.csvSource.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests {
    @Test
    @DisplayName("1 + 1 = 2")
    void addsTwoNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   4",
            "49,  51, 100",
            "1,  100, 101"
    })
    void add(int first, int second, int expectedResult) {
        Calculator calculator = new Calculator();
        //assert calculator.add(1, 2) == 4;
        assert calculator.add(first, second) == expectedResult : "Expected 4 but got " + calculator.add(first, second);

//        assertEquals(expectedResult, calculator.add(first, second),
//                () -> "Expected " + expectedResult + " but got " + calculator.add(first, second) + " for inputs: " + first + " + " + second);
    }
}

/*
JUnit 5'te assertEquals metodu üç parametre alabilir:
beklenen sonuç (expectedResult),
gerçek sonuç (actualResult)
ve bir hata mesajı.

Parametreler
expectedResult (beklenen sonuç): Testten beklenen değerdir.
actualResult (gerçek sonuç): Test edilen metot tarafından döndürülen değerdir.
hata mesajı (hata mesajı sağlayıcısı): Bu, test başarısız olursa görüntülenecek hata mesajıdır.
Hata Mesajı Sağlayıcısı
Kodunuzda hata mesajı sağlayıcısı olarak lambda ifadesi kullanılmış:

java
Copy code
() -> first + " + " + second + " should equal " + expectedResult
Bu lambda ifadesi şu şekilde çalışır:

Lazy Evaluation (Geç Değerlendirme): Lambda ifadesi, test başarısız olursa hata mesajını oluşturur.
Bu, performans açısından avantaj sağlar çünkü mesajın her zaman oluşturulması gerekmez;
yalnızca test başarısız olursa oluşturulur.
String Concatenation (String Birleştirme):
Hata mesajında, first, second ve expectedResult değerleri birleştirilerek anlamlı bir hata mesajı oluşturulur.
 */
    /*
    Java'da assert ifadesi, dilin kendisinde bulunan bir özelliktir ve herhangi bir dış kütüphaneye bağlı değildir. Java 1.4 sürümünden itibaren, assert ifadesi dilin bir parçası olarak eklenmiştir.

assert İfadesi
assert ifadesi, programın belirli bir durumunun doğru olup olmadığını kontrol etmek için kullanılır. Eğer ifade yanlışsa (false), bir AssertionError fırlatılır. Bu, programın belirli bir noktasında belirli bir koşulun geçerli olması gerektiğini belirtmenin bir yoludur.

Kullanımı
assert ifadesinin kullanımı şu şekildedir:


assert condition : errorMessage;
condition: Doğru (true) olması beklenen bir boolean ifadesi.
errorMessage: İsteğe bağlı bir hata mesajı. Koşul yanlış (false) ise, bu mesaj AssertionError ile birlikte görüntülenir.
Örnek

assert calculator.add(1, 2) == 4 : "Expected 4 but got " + calculator.add(1, 2);
Eğer calculator.add(1, 2) 4'e eşit değilse, program bir AssertionError fırlatır ve "Expected 4 but got 3" gibi bir hata mesajı görüntüler.

Etkinleştirme
assert ifadesi, JVM'de varsayılan olarak etkin değildir. assert ifadelerini etkinleştirmek için, programı çalıştırırken -ea (enable assertions) parametresini kullanmanız gerekir:


java -ea MyClass
Özet
Dil Özelliği: assert ifadesi, Java dilinin bir parçasıdır ve Java 1.4'ten itibaren kullanılabilir.
Kullanım: Koşul doğru olmazsa bir AssertionError fırlatır.
Etkinleştirme: -ea parametresi ile JVM'de etkinleştirilir.
     */
/*
@CsvSource anotasyonu, her satırı bir test vakası olarak kullanır
ve add metodunu dört farklı veri setiyle çalıştırır. Bu veri setleri şunlardır:

0, 1, 1
1, 2, 4 (bu satır hataya neden olur)
49, 51, 100
1, 100, 101

 */
/*
@CsvSource'daki her satır bir test vakasıdır.
add metodu, her test vakasında farklı first, second ve expectedResult değerleri ile çalıştırılır.
assertEquals metodu, her veri seti için beklenen ve gerçek sonuçları karşılaştırır.
Hata mesajı, hangi girdilerle hatalı sonuç alındığını net bir şekilde belirtir.
 */