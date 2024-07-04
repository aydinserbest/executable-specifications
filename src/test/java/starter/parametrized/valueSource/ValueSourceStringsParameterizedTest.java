package starter.parametrized.valueSource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
//we added junit-jupiter-params dependency

public class ValueSourceStringsParameterizedTest {
    @ParameterizedTest
    @ValueSource(strings = {"Hello", "World"})
    void testWithStrings(String argument) {
        System.out.println("Parameterized test with (String) parameter:  "
                + argument);
        assertNotNull(argument);
    }
    @ParameterizedTest
    @ValueSource(ints = { 0, 1 })
    void testWithInts(int argument) {
        System.out.println("Parameterized test with (int) argument: " +
                argument);
        assertNotNull(argument);
    }
}
/*
JUnit 5'te @ValueSource Anotasyonu
@ValueSource, parametrized testler için çeşitli basit veri türlerini sağlamak için kullanılır.
Aşağıda JUnit 5'te kullanılabilecek parametre adları ve açıklamaları verilmiştir:

ints: int türünde veri sağlar.
longs: long türünde veri sağlar.
doubles: double türünde veri sağlar.
floats: float türünde veri sağlar.
shorts: short türünde veri sağlar.
bytes: byte türünde veri sağlar.
chars: char türünde veri sağlar.
booleans: boolean türünde veri sağlar.
strings: String türünde veri sağlar.
 */
