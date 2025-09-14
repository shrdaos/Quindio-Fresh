public class ConcretePaymentFactory extends PaymentFactory {
   
    public IPayment createPayment(PaymentType type) {
        switch(type) {
            case CREDIT_CARD:
                return new CreditCardPayment("0000-1111-2222-3333", "123");
            case PSE:
                return new PSEPayment("usuario@banco");
            default:
                throw new IllegalArgumentException("Tipo de pago no soportado: " + type);
        }
    }
}

