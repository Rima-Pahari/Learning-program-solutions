class EmailNotificationFactory extends NotificationFactory {
    Notification createNotification() {
        return new EmailNotification();
    }
}

class SMSNotificationFactory extends NotificationFactory {
    Notification createNotification() {
        return new SMSNotification();
    }
}