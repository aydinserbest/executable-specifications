package starter.repeat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomNumberTest {

    @RepeatedTest(5)
    void test() {
        System.out.println("Random number: " + new Random().nextInt(10));
    }

    @RepeatedTest(10)
        //repeat the test 10 times
    void generateRandomNumber_SHouldProduceValuesWithinRange() {
        Random random = new Random();
        int result = random.nextInt(10);
        assertTrue(result >= 0 && result <= 9); // Bu koşul her zaman doğru-random.nextInt(10) un yapisi geregi
    }

    @RepeatedTest(value = 5, name = "Repetition {currentRepetition} of {totalRepetitions}")
        //display names
    void generateRandomNumber_CustomDisplayName() {
        int result = new Random().nextInt(10);
        System.out.println(result);
        assertTrue(result >= 0 && result <= 9);

    }
    @RepeatedTest(value = 2, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Repeat!")
    void customDisplayName(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }


    @RepeatedTest(10)
    void testWithRepetitionInfo(TestInfo testInfo) {
         System.out.println("Repetition: " + testInfo.getDisplayName()); }

    @RepeatedTest(10)
    void testWithRepetitionInfoAndExecutionInfo(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Repetition: " + repetitionInfo.getCurrentRepetition() + " of " + repetitionInfo.getTotalRepetitions());
        System.out.println("Test: " + testInfo.getDisplayName());
    }
}


/*
Reporting: Each repetition of a repeated test is treated as an individual test execution in the test reports.

 */
    /*
    IntelliJ IDEA'nın "Condition 'result >= 0 && result <= 9' is always 'true'"
    ve "Condition 'result <= 9' is always 'true' when reached"
    uyarılarını vermesinin nedeni,
    random.nextInt(10) metodunun davranışını anlamasıdır.

random.nextInt(10) Metodu
Java'da Random sınıfının nextInt(int bound) metodu,
0 (dahil) ile bound (hariç) arasında rastgele bir tamsayı üretir.
Yani, random.nextInt(10) çağrısı, 0 ile 9 arasında (her ikisi de dahil) bir tamsayı döner.
Bu, metodun tasarımı gereği, result değişkeninin her zaman 0 ile 9 arasında olacağı anlamına gelir.

IntelliJ IDEA'nın Analizi
IntelliJ IDEA, kodun statik analizini yaparken belirli koşulların her zaman doğru olduğunu
veya belirli kod parçalarının asla çalıştırılmayacağını belirleyebilir. Bu durumda:

result >= 0 ifadesi her zaman true olacaktır çünkü
random.nextInt(10) asla negatif bir değer döndüremez.
result <= 9 ifadesi de her zaman true olacaktır çünkü random.nextInt(10) çağrısı
asla 10 veya daha büyük bir değer döndüremez.
Bu nedenle IntelliJ IDEA, bu koşulların her zaman doğru olduğunu ve bu nedenle gereksiz olduğunu belirtiyor.
     */

/*
Why Use Repeated Tests?
●Exposing Flaky Tests:
Tests that sometimes pass and sometimes fail (non-deterministically) are a red flag.
Repeated tests help expose these.
●Testing with Randomness:
When your code relies on random behavior, repeated tests help verify if outcomes fall within expected ranges.
●Stress Testing (carefully):
Repeated tests can be used for simple stress testing scenarios,
but consider dedicated performance testing tools for more comprehensive load testing.

 */