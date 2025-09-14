import java.util.*;

public class CatalogProducts {
    private static CatalogProducts instance;
    private final Map<String, Product> products = new HashMap<>();

    private CatalogProducts() {}

    public static synchronized CatalogProducts getInstance() {
        if (instance == null) {
            instance = new CatalogProducts();
        }
        return instance;
    }

    public void addProduct(Product p) {
        products.put(p.getSku(), p);
    }

    public Product getProductBySku(String sku) {
        return products.get(sku);
    }

    public Collection<Product> listAll() {
        return Collections.unmodifiableCollection(products.values());
    }
}
