package starter.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WithImplicitConversionTest {
    /*
    JUnit 5, String kaynaklardan gelen verileri otomatik olarak belirli türlere dönüştürebilir.
    Bu, testlerde argümanları manuel olarak dönüştürmek zorunda kalmadan
    farklı türlerde veri kullanmanıza olanak tanır. İşte bazı dönüşüm kuralları:
     */
    @ParameterizedTest
    @ValueSource(strings = "true")
    void testWithImplicitConversionToBoolean(Boolean argument) {
        System.out.println("Argument " + argument + " is a type of " + argument.getClass());
        assertTrue(argument);
    }
    @ParameterizedTest
    @ValueSource(strings = "11")
    void testWithImplicitConversionToInteger(Integer argument) {
        System.out.println("Argument " + argument + " is a type of " + argument.getClass());
        assertTrue(argument > 10);
    }
    @ParameterizedTest
    @ValueSource(strings = "2017-07-25")
    void testWithImplicitConversionToLocalDate(LocalDate argument) {
        System.out.println("Argument " + argument + " is a type of " + argument.getClass());
        assertNotNull(argument);
    }

}


/*
JUnit 5, parametrized testlerde farklı türlerdeki argümanları
String kaynaklardan otomatik olarak dönüştürme yeteneğine sahiptir.
Bu, belirli türlerde argümanlar kullanmak istediğinizde, String olarak belirttiğiniz değerlerin
JUnit 5 tarafından otomatik olarak bu türlere dönüştürüleceği anlamına gelir.

Implicit Conversion (Örtük Dönüşüm)
JUnit 5, belirli türler için otomatik dönüşüm kuralları tanımlar.
Örneğin, bir String kaynağı int, boolean, Enum, veya LocalDate gibi türlere dönüştürebilir.
İşte bu kuralların bazıları:

"true" -> Boolean.TRUE
"1" -> (byte) 1
"2" -> (short) 2
"3" -> 3 (integer)
"4" -> 4L (long)
"5.0" -> 5.0f (float)
"6.0" -> 6.0d (double)
"SECONDS" -> TimeUnit.SECONDS (Enum)
"2017-10-24" -> LocalDate.of(2017, 10, 24)

 */