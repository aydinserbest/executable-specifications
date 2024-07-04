package starter.parametrized.csvSource.product;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
//Product Testi: CSV dosyasından sağlanan ürün verilerini kullanarak
// Product sınıfının özelliklerini ve vergi hesaplamasını test eder.
//ProductService Testi: @CsvSource ile sağlanan verileri kullanarak
// ProductService sınıfının indirim hesaplamasını test eder.

public class ProductServiceTest {
    @ParameterizedTest
    @CsvSource({
            "Laptop, 1500, 1350",  // Ürün adı, orijinal fiyat, beklenen indirimli fiyat
            "Headphones, 50, 45"   // Ürün adı, orijinal fiyat, beklenen indirimli fiyat
    })
    void applyDiscount_CalculatesCorrectly(String productName, double price, double discountedPrice) {
        ProductService service = new ProductService();
        double result = service.applyDiscount(productName, price);
        assertEquals(discountedPrice, result, 0.01); // İndirimli fiyatın doğru hesaplandığını kontrol et
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/product_catalog.csv", numLinesToSkip = 1)
    void testProducts(String name, String category, double price, double taxRate, boolean inStock) {
        Product product = new Product(name, category, price, taxRate, inStock);

        // Vergi hesaplamasının doğru olup olmadığını kontrol et
        double expectedTax = price * taxRate;
        assertEquals(expectedTax, product.calculateTax(), 0.01);

        // Ürünün stokta olup olmadığını kontrol et
        assertTrue(product.isInStock() == inStock);

        // Diğer doğrulamalar
        assertEquals(name, product.getName());
        assertEquals(category, product.getCategory());
        assertEquals(price, product.getPrice(), 0.01);
        assertEquals(taxRate, product.getTaxRate(), 0.01);
    }
}
    /*
    Açıklama
ProductService Sınıfı:

applyDiscount(String productName, double price) metodu, verilen ürün adı ve fiyatına göre bir indirim uygular
ve indirimli fiyatı döner.
Bu örnekte, "Laptop" ve "Headphones" ürünleri için %10 indirim uygulanır.
Test Sınıfı (ProductServiceTest):

applyDiscount_CalculatesCorrectly metodu, @ParameterizedTest ve @CsvSource anotasyonları kullanılarak
parametrized test yapar.
@CsvSource ile belirtilen veriler test metoduna argüman olarak geçilir:
ürün adı (productName), orijinal fiyat (price), ve beklenen indirimli fiyat (discountedPrice).
assertEquals(discountedPrice, result, 0.01) ifadesi,
applyDiscount metodunun doğru sonuç verip vermediğini kontrol eder ve beklenen değerle karşılaştırır.
Burada üçüncü parametre olan 0.01, kabul edilen küçük farkı belirtir,
bu sayede küçük yuvarlama hataları göz ardı edilebilir.
Test Çalışması
Bu test çalıştırıldığında, Laptop ve Headphones ürünleri için
applyDiscount metodunun doğru çalışıp çalışmadığı kontrol edilir:

İlk veri satırı için ("Laptop, 1500, 1350"):

Ürün adı: Laptop
Orijinal fiyat: 1500
Beklenen indirimli fiyat: 1350 (1500 - %10 = 1500 - 150 = 1350)
service.applyDiscount("Laptop", 1500) sonucu 1350 olmalıdır, bu yüzden test geçer.
İkinci veri satırı için ("Headphones, 50, 45"):

Ürün adı: Headphones
Orijinal fiyat: 50
Beklenen indirimli fiyat: 45 (50 - %10 = 50 - 5 = 45)
service.applyDiscount("Headphones", 50) sonucu 45 olmalıdır, bu yüzden test geçer.
Bu örnek, JUnit 5 ile parametrized test yapmanın
ve indirim hesaplayan bir yardımcı sınıf (ProductService) yazmanın temel bir örneğidir
     */

/*
kodda geçen assertEquals(expectedTax, product.calculateTax(), 0.01) ifadesini ve 0.01'in ne anlama geldiğini açıklayalım.

assertEquals Metodu ve Tolerans Değeri
JUnit'de assertEquals metodu, iki değerin eşit olup olmadığını kontrol eder.
Bu metodun üç parametreli bir versiyonu vardır:

java
Copy code
assertEquals(double expected, double actual, double delta)
expected: Beklenen değer.
actual: Gerçek değer (test edilen metodun döndürdüğü değer).
delta: Kabul edilen küçük fark (tolerans).
delta Parametresi (0.01)
delta: Bu parametre, iki değerin eşit kabul edilebilmesi için aralarındaki izin verilen maksimum farkı belirtir.
Bu, özellikle double veya float türünde sayılarla çalışırken kullanılır
çünkü bu tür sayılarda küçük yuvarlama hataları olabilir.
0.01: Bu, kabul edilen tolerans değeridir. Yani, beklenen değer ile gerçek değer arasındaki fark
0.01'den küçük veya eşit ise test geçer.
Neden delta Kullanılır?
Bilgisayarlar double ve float türündeki sayıları tam olarak temsil edemeyebilirler.
Bu nedenle, iki double değeri karşılaştırırken çok küçük yuvarlama hataları meydana gelebilir. delta parametresi,
bu tür küçük farkların testin başarısını etkilememesi için kullanılır.
 */

/*
assertEquals(expected, actual, delta) ifadesindeki delta, iki değerin eşit kabul edilebilmesi için
aralarındaki maksimum kabul edilebilir farkı belirtir.
Bu, özellikle double ve float gibi kayan nokta sayılarının karşılaştırılmasında kullanılır.
delta değeri, beklenen ve gerçek değerler arasındaki farkın kabul edilebilir sınırını temsil eder.
delta herhangi bir değerle çarpılmaz, yalnızca farkı kontrol etmek için kullanılır.

Açıklama ve İşleyişi
JUnit'in assertEquals metodu, beklenen ve gerçek değerler arasındaki farkın
belirtilen delta (tolerans) içinde olup olmadığını kontrol eder. Bu, aşağıdaki şekilde çalışır:


assertEquals(expected, actual, delta)
expected: Beklenen değer.
actual: Gerçek değer (test edilen metodun döndürdüğü değer).
delta: Kabul edilen küçük fark (tolerans).
Örnek Üzerinde Açıklama
Örneğin:


assertEquals(36.0, 36.0, 0.01)
Bu örnekte:

expected: 36.0 (beklenen değer)
actual: 36.0 (gerçek değer)
delta: 0.01 (kabul edilen fark)
JUnit şu kontrolü yapar:

Beklenen ve gerçek değer arasındaki farkı hesaplar:


double difference = Math.abs(expected - actual);
Bu farkın deltadan küçük veya eşit olup olmadığını kontrol eder:


if (difference <= delta) {
    // Test geçer
} else {
    // Test başarısız olur
}
Yani, bu durumda Math.abs(36.0 - 36.0) <= 0.01 kontrol edilir:

Math.abs(36.0 - 36.0) = 0.0
0.0 <= 0.01 -> true olduğu için test geçer.
Farklı Örnekler
Diyelim ki expected 36.0 ve actual 36.005 olsun:


assertEquals(36.0, 36.005, 0.01)
Bu durumda:

Math.abs(36.0 - 36.005) = 0.005
0.005 <= 0.01 -> true olduğu için test geçer.
Ancak, eğer actual 36.02 olsaydı:


assertEquals(36.0, 36.02, 0.01)
Bu durumda:

Math.abs(36.0 - 36.02) = 0.02
0.02 <= 0.01 -> false olduğu için test başarısız olur.
Sonuç
delta değeri, beklenen ve gerçek değerler arasındaki kabul edilebilir maksimum farkı temsil eder.
Bu, özellikle küçük yuvarlama hatalarının önemli olduğu durumlarda, kayan nokta sayılarıyla çalışırken önemlidir.
delta herhangi bir değerle çarpılmaz;
yalnızca iki sayı arasındaki farkı kabul edilebilir sınır içinde olup olmadığını kontrol etmek için kullanılır.


 */