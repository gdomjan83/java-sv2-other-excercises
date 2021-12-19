package potvizsga3.filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductFileManager {
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void readProductsFromFile(Path path) {
        try {
            List<String> productAsString = Files.readAllLines(path);
            addProducts(productAsString);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public void writePriceOverToFile(Path path, int minPrice) {
        try {
            Files.write(path, filterProducts(minPrice));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't write file!", ioe);
        }
    }

    private List<String> filterProducts(int minPrice) {
        List<String> linesToWrite = new ArrayList<>();
        for (Product actual : products) {
            if (actual.getPrice() > minPrice) {
                linesToWrite.add(actual.toString());
            }
        }
        return linesToWrite;
    }

    private void addProducts(List<String> productsAsString) {
        for (String actual : productsAsString) {
            String[] productData = actual.split(";");
            products.add(createProduct(productData[1], productData[2], productData[0]));
        }
    }

    private Product createProduct(String name, String price, String productID) {
        return new Product(name, Integer.valueOf(price), productID);
    }
}
