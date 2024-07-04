package starter.parametrized;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import starter.parametrized.valueSource.NumberUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomNamesParameterizedTest {
    @DisplayName("Test Konteynerinin Görüntüleme Adı")
    @ParameterizedTest(name = "[{index}] İlk argüman=\"{0}\", İkinci argüman={1}")
    @CsvSource({ "mastering, 1", "parameterized, 2", "tests, 3" })
    void testWithCustomDisplayNames(String first, int second) {
        System.out.println("Parametrelerle test ediliyor: " + first + " ve " + second);
    }
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 8, -10, 0 })
    @DisplayName("isEven should return true for even numbers") // More descriptive base name
    void isEven_ShouldReturnTrueForEvenNumbers_WithDisplayName(int number) {
        assertTrue(NumberUtils.isEven(number)); }

}
