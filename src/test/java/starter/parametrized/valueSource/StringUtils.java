package starter.parametrized.valueSource;

public class StringUtils {
    // Bir kelimenin palindrom olup olmadığını kontrol eden metod
    public static boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
}
    /*
    Karşılaştırma Operatörleri ve Boolean Değerler
    Karşılaştırma operatörleri, iki değeri karşılaştırır ve
    bu karşılaştırmanın sonucunu boolean olarak döner:

    ==: Eşitlik operatörü, iki değerin eşit olup olmadığını kontrol eder.
    Eğer iki değer eşitse, sonuç true olur.
    Eğer iki değer eşit değilse, sonuç false olur.
    input == null İfadesi
    input == null: Bu ifade, input değişkeninin null olup olmadığını kontrol eder.
    Eğer input gerçekten null ise, bu ifade true döner.
    Eğer input null değilse (yani bir değere sahipse), bu ifade false döner.
 */
/*
trim() metodunun nasıl çalıştığını daha net bir şekilde açıklayalım.

trim() Metodunun Çalışma Şekli
trim() metodu, bir string'in başındaki ve sonundaki boşluk karakterlerini kaldırır,
ancak string'in içindeki boşluk karakterlerine dokunmaz.

Örneklerle Açıklama
Örnek 1: İçerisinde Boşluk Olan Bir String

    String str3 = "Hello, World!";

Bu string'in başında veya sonunda boşluk karakteri yoktur,
ancak "Hello," ve "World!" kelimeleri arasında bir boşluk vardır.
trim() metodu, sadece baştaki ve sondaki boşlukları kaldırdığı için bu string üzerinde uygulandığında string değişmez.

    System.out.println(str3.trim()); // "Hello, World!"

Örnek 2: Sadece Boşluklardan Oluşan Bir String

    String str2 = "   ";

Bu string'in tamamı boşluk karakterlerinden oluşur. trim() metodu, bu string'in başındaki ve sonundaki
(bu durumda tamamı) boşlukları kaldırır ve geriye boş bir string ("") kalır.

isEmpty() metodu, string'in uzunluğunun sıfır olup olmadığını kontrol eder. "": Hiçbir karakter içermez.
Bu durumda, isEmpty() metodu true döner çünkü uzunluk sıfırdır.


System.out.println(str2.trim()); // ""

Örnek 3: Baştan ve Sondan Boşluk İçeren Bir String

    String str4 = "   Hello, World!   ";
Bu string'in başında ve sonunda boşluk karakterleri vardır.
trim() metodu, bu boşlukları kaldırır ve geriye sadece "Hello, World!" kalır.

    System.out.println(str4.trim()); // "Hello, World!"

Neden trim() İçerideki Boşlukları Kaldırmaz?
trim() metodunun tasarımı gereği, sadece string'in başındaki ve sonundaki boşluk karakterlerini kaldırır.
Bu, metodu kullanarak string'in başında ve sonunda gereksiz boşlukları temizlemeyi amaçlar.
İçerideki boşluklar ise metin düzenini bozabilir ve çoğu durumda gerekli olduklarından dolayı dokunulmaz.

Özet
trim() metodu, bir string'in sadece başındaki ve sonundaki boşluk karakterlerini kaldırır.
str3 örneğinde ( "Hello, World!" ), başında veya sonunda boşluk olmadığı için trim() metodu string'i değiştirmez.
str2 örneğinde ( " " ), sadece boşluklardan oluştuğu için
trim() metodu string'in tamamını kaldırır ve geriye boş bir string ("") kalır.
Bu yüzden, "Hello, World!" gibi bir string'de trim() metodu ortadaki boşlukları kaldırmazken,
" " gibi bir string'de tüm boşlukları kaldırır ve boş bir string bırakır.

input.trim()
str2 için: " ".trim()ifadesi çağrılır.trim()yöntemi, string'in başındaki ve sonundaki boşlukları kaldırır.
Bu durumda," "string'i" "` olur (yani boş bir string).


 */
/*
Java'da || (veya) mantık operatörü "kısa devre" (short-circuit) olarak çalışır.
Bu, operatörün sol tarafındaki ifade true ise, sağ tarafındaki ifadeyi kontrol etmeye gerek olmadığı anlamına gelir.
Ancak sol taraf false ise, sağ taraf kontrol edilir.

Senin belirttiğin gibi, str3 için input == null ifadesi false döner. Bu durumda || operatörü,
sağ tarafı da kontrol eder. Bu yüzden input == null ifadesi false dönerken,
input.trim().isEmpty() ifadesi kontrol edilir.

Örnek Üzerinden Açıklama
Kodun tamamını yeniden ele alalım:


public class StringUtils {
    public static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
}

String str3 = "Hello, World!";
System.out.println(StringUtils.isBlank(str3)); // false
Bu adımlarda gerçekleşen işlemler şunlardır:

Null Kontrolü (Null Check):

input == null
str3 için: str3 == null ifadesi false döner çünkü str3 null değildir.
Boşlukları Kırpma ve Boşluk Kontrolü (Trimming Whitespaces and Empty Check):


input.trim().isEmpty()
str3 için: "Hello, World!".trim().isEmpty()ifadesi çağrılır.trim()yöntemi,
"Hello, World!"string'inde değişiklik yapmaz çünkü başında ve sonunda boşluk yoktur.
isEmpty()yöntemi ise
"Hello, World!"string'inin boş olmadığını kontrol eder vefalse` döner.

Mantık Operatörü (Logical Operator)
|| (veya) operatörü ile:

return input == null || input.trim().isEmpty();
false || false olur ve bu da false döner.
Kısa Devre Mantığı (Short-Circuit Logic)
Kısa devre mantığında:

Eğer input == null ifadesi true olsaydı, || operatörü sağ tarafı kontrol etmez ve doğrudan true dönerdi.
Ancak input == null ifadesi false olduğu için, || operatörü sağ tarafı da kontrol eder.
Bu nedenle, str3 null olmadığı için ilk kontrol false döner ve ikinci kontrol yapılır.
İkinci kontrol de false döndüğü için, sonuç olarak isBlank yöntemi false döner.

 */

/*
" " (sadece boşluk içeren) ve "" (boş) string'ler arasındaki fark nedir ve neden biri boş kabul edilirken
diğeri kabul edilmez?
Bu durumu daha iyi anlamak için Java'da string'lerin nasıl işlendiğini ve isEmpty() metodunun nasıl çalıştığını inceleyelim.

Boş ve Boşluk İçeren String'ler
Boş String:

"": Hiçbir karakter içermez.
isEmpty() metodu, string'in uzunluğunun sıfır olup olmadığını kontrol eder.
Bu durumda, isEmpty() metodu true döner çünkü uzunluk sıfırdır.
Boşluk İçeren String:

" ": Bir veya daha fazla boşluk karakteri içerir.
isEmpty() metodu, string'in uzunluğunun sıfır olup olmadığını kontrol eder.
Bu durumda, isEmpty() metodu false döner çünkü string'in uzunluğu sıfırdan büyüktür (bu örnekte 1).
Kod Örnekleri

String str1 = "";
String str2 = " ";

System.out.println(str1.isEmpty()); // true
System.out.println(str2.isEmpty()); // false
Yukarıdaki kod, str1'in isEmpty() metodunun true döndüğünü, ancak str2'nin isEmpty() metodunun false döndüğünü gösterir.

trim() Metodunun Kullanımı
trim() metodu, string'in başındaki ve sonundaki boşluk karakterlerini kaldırır.
Eğer bir string sadece boşluk karakterlerinden oluşuyorsa, trim() metodu
bu boşlukları kaldırır ve geriye boş bir string ("") bırakır. Bu durumda, isEmpty() metodu true döner.


String str3 = "   ";

System.out.println(str3.trim().isEmpty()); // true
Yukarıdaki kodda str3 string'i sadece boşluk karakterlerinden oluşur.
trim() metodu bu boşlukları kaldırır ve geriye boş bir string bırakır, bu nedenle isEmpty() metodu true döner.

isBlank Metodunun Mantığı
java
Copy code
public static boolean isBlank(String input) {
    return input == null || input.trim().isEmpty();
}
Bu metodun mantığı, input string'inin boş veya sadece boşluklardan oluşup oluşmadığını kontrol etmektir:

Eğer input null ise, true döner.
Eğer input sadece boşluklardan oluşuyorsa, trim() bu boşlukları kaldırır ve geriye boş bir string kalır,
bu nedenle isEmpty() true döner.
Özet
"" string'i tamamen boş olduğu için isEmpty() metodu true döner.
" " string'i boşluk karakteri içerdiği için isEmpty() metodu false döner.
trim() metodu kullanıldığında, " " gibi sadece boşluk karakterlerinden oluşan string'ler boş hale gelir (""),
bu nedenle isEmpty() metodu true döner.
 */


