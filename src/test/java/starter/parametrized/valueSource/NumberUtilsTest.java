package starter.parametrized.valueSource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberUtilsTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 8, -10, 0 })
    void isEven_ShouldReturnTrueForEvenNumbers(int number) {
        assertTrue(NumberUtils.isEven(number));
    }
    @ParameterizedTest
    @ValueSource(strings = {"radar", "madam", "racecar"})
    void isPalindrome_ShouldReturnTrueForPalindromes(String word) {
        assertTrue(StringUtils.isPalindrome(word));  }

}
    /*
    @ValueSource: Specifies an array of values to be passed as arguments to the test method.
    Argument Placeholder: The test method parameter (here, int number) receives each value from the source
    during iterations of the test.

     */
