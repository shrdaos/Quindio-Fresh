public class SMSNotification implements INotification {
    @Override
    public void notify(Client client, String message) {
        System.out.println("Enviando SMS a " + client.getPhone() + ": " + message);
    }
}

