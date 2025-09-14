public class OrderItem {
    private final Product product;
    private final int quantity;

    public OrderItem(Product product, int quantity) {
        if (product == null) throw new IllegalArgumentException("Product no puede ser null");
        if (quantity <= 0) throw new IllegalArgumentException("Quantity debe ser > 0");
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double subtotal() { return product.getPrice() * quantity; }
}
