public class FactoryMethodDemo {
    public static void main(String[] args) {
        NotificationFactory factory;

        // For Email Notification
        factory = new EmailNotificationFactory();
        factory.sendNotification();

        // For SMS Notification
        factory = new SMSNotificationFactory();
        factory.sendNotification();
    }
}