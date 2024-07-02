package starter;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DisabledJunit5Test")
@Disabled("all tests in this class disabled")  //skipping tests
public class DisabledJunit5Test {
    @Test
    void mySimpleTest1() {
        // My test logic here
        System.out.println("slm");
    }
   @Disabled("mySimpleTest2 disabled") //when we run test, it does not work only text is seen in output
   //at method level skipping test
    @Test
    void mySimpleTest2() {
        // My test logic here
        System.out.println("slm1");
    }

}
