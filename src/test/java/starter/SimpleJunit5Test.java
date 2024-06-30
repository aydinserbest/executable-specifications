package starter;


import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class SimpleJunit5Test {
    @Test
    void mySimpleTest1() {
        // My test logic here
        System.out.println("slm1");
    }
    @Disabled("mySimpleTest2 disabled") //when we run test, it does not work only text is seen in output
    @Test
    void mySimpleTest2() {
        // My test logic here
        System.out.println("slm2");
    }

}
