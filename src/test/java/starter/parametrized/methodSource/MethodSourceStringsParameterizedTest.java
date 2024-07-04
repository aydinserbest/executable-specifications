package starter.parametrized.methodSource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
//@ValueSource anotasyonunda tanımlanmamış özel bir veri türüne ihtiyacınız varsa,
// @MethodSource veya @ArgumentsSource gibi diğer anotasyonları kullanabilirsiniz.
// Bu anotasyonlar, veri sağlamak için özel yöntemler veya ArgumentsProvider sınıfları kullanmanıza olanak tanır.

public class MethodSourceStringsParameterizedTest {
    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithMethodSource(String argument) {
        System.out.println("Parameterized test with (String) argument: " + argument);
        assertNotNull(argument);
    }

    static Stream<String> stringProvider() {
        return Stream.of("Hello", "JUnit", "5");
    }
    @ParameterizedTest
    @MethodSource("arrayProvider")
    void testWithArray(String argument) {
        System.out.println("Parameterized test with (String) argument: " + argument);
        assertNotNull(argument);
    }

    static String[] arrayProvider() {
        return new String[]{"Hello", "JUnit", "5"};
    }
    @ParameterizedTest
    @MethodSource("mapProvider")
    void testWithMap(String key, Integer value) {
        System.out.println("Parameterized test with (String, Integer) arguments: " + key + ", " + value);
        assertNotNull(key);
        assertNotNull(value);
    }

    static Stream<Arguments> mapProvider() {
        Map<String, Integer> map = Map.of("Hello", 1, "JUnit", 2, "5", 3);
        return map.entrySet().stream().map(entry -> Arguments.of(entry.getKey(), entry.getValue()));
    }

}


