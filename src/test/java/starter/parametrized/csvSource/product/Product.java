package starter.parametrized.csvSource.product;

//Product sınıfında vergi hesaplaması yapıliyor

public class Product {

        private String name;
        private String category;
        private double price;
        private double taxRate;
        private boolean inStock;

        public Product(String name, String category, double price, double taxRate, boolean inStock) {
            this.name = name;
            this.category = category;
            this.price = price;
            this.taxRate = taxRate;
            this.inStock = inStock;
        }

        public double calculateTax() {
            return price * taxRate;
        }

        // Getter metodları
        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }

        public double getTaxRate() {
            return taxRate;
        }

        public boolean isInStock() {
            return inStock;
        }
    }


