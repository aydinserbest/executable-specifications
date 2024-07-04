package starter.parametrized.csvSource.addresse;

public class AddressValidator {
    // Adres ve posta kodunun geçerli olup olmadığını kontrol eden metod
    public boolean validate(String address, String zipCode) {
        // Basit bir doğrulama örneği: posta kodu sadece rakamlardan oluşmalıdır ve belirli uzunlukta olmalıdır
        return zipCode.matches("\\d{5}") && !address.isEmpty();
    }
}
    /*
    validate(String address, String zipCode) metodu,
    verilen adresin ve posta kodunun geçerli olup olmadığını kontrol eder.
Bu basit örnekte, posta kodunun sadece rakamlardan oluşup oluşmadığı
ve belirli bir uzunlukta olup olmadığı kontrol edilir (zipCode.matches("\\d{5}")).
Adresin boş olup olmadığı kontrol edilir (!address.isEmpty()).
     */
/*
zipCode.matches("\\d{5}") ifadesi,
zipCode değişkeninin değeri ile belirli bir düzenli ifadeye (regex) uyup uymadığını kontrol eder.
Bu özel regex, 5 basamaklı bir sayı dizisini tanımlar.
Şimdi bu ifadenin ayrıntılarını inceleyelim:

Düzenli İfade (Regex) Açıklaması

\d: Bu, herhangi bir rakamı (0-9 arası) temsil eder.
{5}: Bu, kendisinden önce gelen ifadenin tam olarak 5 kez tekrar edilmesi gerektiğini belirtir.

Dolayısıyla, \\d{5} ifadesi, tam olarak 5 rakamdan oluşan bir dizi anlamına gelir.
Bu ifade, posta kodunun 5 basamaklı bir sayı olup olmadığını kontrol eder.

İşleyişi
zipCode.matches("\d{5}"): zipCode değişkeninin değeri 5 rakamdan oluşuyorsa true döner, aksi halde false döner.
Örneğin, zipCode "90210" ise, matches("\\d{5}") ifadesi true döner.
Eğer zipCode "ABCDE" veya "123" ise, bu ifade false döner.
Örnekler
Geçerli Posta Kodları:

"12345" (5 rakam)
"00000" (5 rakam)
Geçersiz Posta Kodları:

"1234" (4 rakam, eksik)
"123456" (6 rakam, fazla)
"12a45" (alfabetik karakter içeriyor)
"ABCDE" (sadece alfabetik karakterler)

Kullanım Amacı
Bu tür bir regex kullanarak posta kodlarının geçerliliğini kontrol etmek,
doğru formatta olmayan verilerin filtrelenmesine yardımcı olur.
Özellikle, posta kodları belirli bir formata sahip olmalıdır
(örneğin, ABD'deki posta kodları genellikle 5 basamaklıdır).

Özet
zipCode.matches("\\d{5}") ifadesi,
zipCode değerinin 5 rakamdan oluşup oluşmadığını kontrol eden bir düzenli ifade kullanımıdır.
Bu, posta kodlarının doğru formatta olup olmadığını doğrulamak için kullanılır.
 */
