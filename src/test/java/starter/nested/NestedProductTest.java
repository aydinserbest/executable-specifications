package starter.nested;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NestedProductTest {

        @Nested
        class WhenProductIsNew {
            // This nested class describes tests for the scenario where the product is new.

            @Test
            void applyDiscount_ShouldThrowException() {
                Product newProduct = new Product("New Product", 100.0, false, 0.0, 0.0);
                assertThrows(IllegalStateException.class, () -> productService.applyDiscount(newProduct));
            }
        }

        @Nested
        class WhenProductIsInStock {
            // This nested class describes tests for the scenario where the product is in stock.

            @Test
            void calculatePrice_ShouldIncorporateTaxAndShipping() {
                Product inStockProduct = new Product("In Stock Product", 100.0, true, 0.18, 10.0);
                double expectedPrice = 100.0 + (100.0 * 0.18) + 10.0; // Base price + Tax + Shipping
                assertEquals(expectedPrice, productService.calculatePrice(inStockProduct));
            }

            @Test
            void applyDiscount_ShouldApplyDiscountCorrectly() {
                Product inStockProduct = new Product("In Stock Product", 100.0, true, 0.18, 10.0);
                productService.applyDiscount(inStockProduct);
                assertEquals(90.0, inStockProduct.getPrice(), 0.01); // 10% discount applied
            }
        }

        private final ProductService productService = new ProductService();

        // Simple implementation of ProductService for demonstration purposes
        static class ProductService {
            void applyDiscount(Product product) {
                if (!product.isInStock()) {
                    throw new IllegalStateException("Cannot apply discount to a new product");
                }
                product.setPrice(product.getPrice() * 0.9); // Apply a 10% discount
            }

            double calculatePrice(Product product) {
                return product.getPrice() + (product.getPrice() * product.getTaxRate()) + product.getShippingCost();
            }
        }

        // Simple implementation of Product class for demonstration purposes
        static class Product {
            private String name;
            private double price;
            private boolean inStock;
            private double taxRate;
            private double shippingCost;

            public Product(String name, double price, boolean inStock, double taxRate, double shippingCost) {
                this.name = name;
                this.price = price;
                this.inStock = inStock;
                this.taxRate = taxRate;
                this.shippingCost = shippingCost;
            }

            public boolean isInStock() {
                return inStock;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public double getPrice() {
                return price;
            }

            public double getTaxRate() {
                return taxRate;
            }

            public double getShippingCost() {
                return shippingCost;
            }
        }
    }


