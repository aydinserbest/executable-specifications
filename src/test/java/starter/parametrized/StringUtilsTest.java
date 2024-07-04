package starter.parametrized;

import org.junit.jupiter.api.Test;
import starter.parametrized.valueSource.StringUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilsTest {
    @Test
    public void isBlank_ShouldReturnTrueForNullOrBlankStrings() {
        assertTrue(StringUtils.isBlank(null));
        assertTrue(StringUtils.isBlank(""));
        assertTrue(StringUtils.isBlank("  "));
    }
    @Test
    public void isBlank_ShouldReturnFalseForNonNullStrings() {
      //  assertTrue(StringUtils.isBlank("test")); // Incorrect assertion
    }


        @Test
    void isBlank() {
        String str = " "; //isEmpty() metodu, string'in uzunluğunun sıfır olup olmadığını kontrol eder.
        // "": Hiçbir karakter içermez.
        //Bu durumda, isEmpty() metodu true döner çünkü uzunluk sıfırdır.
        String str2 = "   "; //" ": Bir veya daha fazla boşluk karakteri içerir.
        //isEmpty() metodu, string'in uzunluğunun sıfır olup olmadığını kontrol eder.
       // Bu durumda, isEmpty() metodu false döner çünkü string'in uzunluğu sıfırdan büyüktür
       //!!! ancak trim metodu bosluklari kaldirdigi icin true olur !!!
        String str3 = null;
        String str4 = "Hello, world!";
        System.out.println(StringUtils.isBlank(str)); // ?
        System.out.println(StringUtils.isBlank(str2)); // ?
        System.out.println(StringUtils.isBlank(str3)); // ?
        System.out.println(StringUtils.isBlank(str4)); // ?
    }
}
    //Java'da || (veya) mantık operatörü
//Bu, operatörün sol tarafındaki ifade true ise, sağ tarafındaki ifadeyi kontrol etmeye gerek olmadığı anlamına gelir.
//Ancak sol taraf false ise, sağ taraf kontrol edilir.



