package HiFresh.aankoop.persistency;

import HiFresh.aankoop.domain.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Sami Filjak
 * 27/12/2023
 */
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public void add(Product product) {
        products.add(product);
    }

    public Product get(long ingredientProductId) {
        return products.stream().filter(product -> product.getId() == ingredientProductId).findFirst().orElse(null);
    }
}