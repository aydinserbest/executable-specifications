package starter.unittests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("non-functional")
public class NonFunctionalTest {

    @Test
    void testOne() {
        System.out.println("Non-Functional Test 1 (Performance/Load)");
    }
    @Test
    void testTwo() {
        System.out.println("Non-Functional Test 2 (Performance/Stress)");
    }
    @Test
    void testThree() {
        System.out.println("Non-Functional Test 3 (Security)");
    }
    @Test
    void testFour() {
        System.out.println("Non-Functional Test 4 (Usability)"); }


}
