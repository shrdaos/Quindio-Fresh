public class Main {
    public static void main(String[] args) {
        CatalogProducts catalog = CatalogProducts.getInstance();
        catalog.addProduct(new Product("P001", "Café especial", 25000));
        catalog.addProduct(new Product("P002", "Banano", 3000));

        Client client = new Client("Ana", "ana@example.com", "3001112222");
        Order order = new Order.OrderBuilder("ORD-1001", client)
                .addItem(catalog.getProductBySku("P001"), 1)
                .addItem(catalog.getProductBySku("P002"), 5)
                .discountCode("PROMO10")
                .build();

        System.out.println("Total: " + order.calculateTotal());

        // Pago
        PaymentFactory pf = new ConcretePaymentFactory();
        IPayment payment = pf.createPayment(PaymentType.CREDIT_CARD);
        if (payment.pay(order)) {
            // Envío
            ShippingFactory sf = new ConcreteShippingFactory();
            IShipping shipping = sf.createShipping(ShippingType.STANDARD);
            System.out.println("Costo envío: " + shipping.calculateCost(order));

            // Notificación
            NotificationFactory nf = new ConcreteNotificationFactory();
            INotification notifier = nf.createNotification(NotificationType.EMAIL);
            notifier.notify(client, "Su pedido " + order.getId() + " ha sido procesado.");
        }
    }
}


