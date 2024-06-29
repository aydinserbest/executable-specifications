package starter;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("all tests in this class disabled")
public class DisabledJunit5Test {
    @Test
    void mySimpleTest1() {
        // My test logic here
        System.out.println("slm");
    }
   // @Disabled("mySimpleTest2 disabled") //when we run test, it does not work only text is seen in output
    @Test
    void mySimpleTest2() {
        // My test logic here
        System.out.println("slm1");
    }

}
