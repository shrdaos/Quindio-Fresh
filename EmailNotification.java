public class EmailNotification implements INotification {
    public void notify(Client client, String message) {
        System.out.println("Enviando EMAIL a " + client.getEmail() + ": " + message);
    }
}
