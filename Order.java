import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Order {
    private final String id;
    private final Date date;
    private final Client client;
    private final List<OrderItem> items;
    private final String address;
    private final String notes;
    private final String discountCode;

    private Order(OrderBuilder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.client = builder.client;
        this.items = Collections.unmodifiableList(new ArrayList<>(builder.items));
        this.address = builder.address;
        this.notes = builder.notes;
        this.discountCode = builder.discountCode;
    }

    public String getId() { return id; }
    public Date getDate() { return new Date(date.getTime()); }
    public Client getClient() { return client; }
    public List<OrderItem> getItems() { return items; }
    public String getAddress() { return address; }
    public String getNotes() { return notes; }
    public String getDiscountCode() { return discountCode; }

    public double calculateTotal() {
        double total = 0.0;
        for (OrderItem it : items) total += it.subtotal();
        if (discountCode != null && !discountCode.isEmpty()) {
            // ejemplo simple: 10% de descuento
            total *= 0.9;
        }
        return total;
    }

    // Builder estático
    public static class OrderBuilder {
        private final String id;
        private final Date date;
        private final Client client;
        private final List<OrderItem> items = new ArrayList<>();
        private String address;
        private String notes;
        private String discountCode;

        public OrderBuilder(String id, Client client) {
            if (id == null || id.isEmpty()) throw new IllegalArgumentException("id requerido");
            if (client == null) throw new IllegalArgumentException("client requerido");
            this.id = id;
            this.date = new Date();
            this.client = client;
        }

        public OrderBuilder addItem(Product p, int qty) {
            this.items.add(new OrderItem(p, qty));
            return this;
        }

        public OrderBuilder address(String addr) { this.address = addr; return this; }
        public OrderBuilder notes(String note) { this.notes = note; return this; }
        public OrderBuilder discountCode(String code) { this.discountCode = code; return this; }

        public Order build() {
            if (items.isEmpty()) throw new IllegalStateException("Order debe tener al menos un item");
            return new Order(this);
        }
    }
}

