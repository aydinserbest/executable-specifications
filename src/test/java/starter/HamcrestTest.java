package starter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/*
JUnit 4 identified tests basically with the name of the method annotated with @Test.
This imposes a limitation on name tests,

 */
@DisplayName("Hamcrest Test")
@Tag("hamcrest")
public class HamcrestTest {
    @Test
    void assertWithHamcrestMatcher() {
        assertThat(2 + 1, equalTo(3));
        assertThat("Foo", notNullValue());
        assertThat("Hello world", containsString("world"));
    }
}
/*
problem, Jupiter provides the ability of declaring a custom display name (different to the test name) for tests.
This is done with the annotation @DisplayName.
This annotation declares a custom display name for a test class or a test method.
This name will be displayed by test runners and reporting tools, and it can contain spaces, special characters, and even emojis.

 */
