public class PSEPayment implements IPayment {
    private final String account;

    public PSEPayment(String account) {
        this.account = account;
    }

    public boolean pay(Order order) {
        System.out.println("Procesando pago PSE para orden " + order.getId());
        return true;
    }
}
