package potvizsga3.filemanipulation;

public class Product {
    private String name;
    private int price;
    private String productID;

    public Product(String name, int price, String productID) {
        this.name = name;
        this.price = price;
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getProductID() {
        return productID;
    }

    @Override
    public String toString() {
        return productID + ";" + name + ";" + price;
    }
}
