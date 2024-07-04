package starter.parametrized.csvSource.product;

public class ProductService {
    // Ürün adı ve fiyatına göre indirim uygulayan metod
    public double applyDiscount(String productName, double price) {
        double discountRate = 0.0;

        // Ürün adına göre indirim oranı belirleme
        switch (productName) {
            case "Laptop":
                discountRate = 0.10; // Laptoplar için %10 indirim
                break;
            case "Headphones":
                discountRate = 0.10; // Kulaklıklar için %10 indirim
                break;
            // Diğer ürünler için başka indirim oranları eklenebilir
            default:
                discountRate = 0.0; // Diğer ürünlerde indirim yok
                break;
        }

        // İndirim uygulanmış fiyatı hesaplama
        return price - (price * discountRate);
    }
}
