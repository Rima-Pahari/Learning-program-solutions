abstract class NotificationFactory {
    abstract Notification createNotification();

    public void sendNotification() {
        Notification notification = createNotification();
        notification.notifyUser();
    }
}