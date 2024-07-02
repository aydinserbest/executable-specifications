package starter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@Tag("standardAssertions")
public class StandardAssertionsTest {
    @Test
    void standardAssertions() {
        assertEquals(2, 2);
        assertTrue(true,
                "The optional assertion message is now the last parameter");
        assertFalse(false, () -> "Really " + "expensive " + "message"
                + ".");
    }
}
/*
For each of the assertions, an optional failure message (String) can be provided.
This message is always the last parameter in the assertion method.
***
This is a small difference with respect to JUnit 4,
in which this message was the first parameter in the method invocation.

 */
