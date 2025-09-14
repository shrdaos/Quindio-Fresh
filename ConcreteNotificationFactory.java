public class ConcreteNotificationFactory extends NotificationFactory {
    
    public INotification createNotification(NotificationType type) {
        switch(type) {
            case EMAIL: return new EmailNotification();
            case SMS: return new SMSNotification();
            default:
                throw new IllegalArgumentException("Notificación no soportada: " + type);
        }
    }
}
