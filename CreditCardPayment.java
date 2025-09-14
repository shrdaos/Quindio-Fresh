public class CreditCardPayment implements IPayment {
    private final String cardNumber;
    private final String cvv;

    public CreditCardPayment(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    public boolean pay(Order order) {
        System.out.println("Procesando pago con tarjeta para orden " + order.getId());
        // simulación de proceso
        return true;
    }
}
