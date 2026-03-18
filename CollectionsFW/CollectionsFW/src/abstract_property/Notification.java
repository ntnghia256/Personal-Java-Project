package abstract_property;

abstract class Notification {
    protected String senderName;

    public Notification(String senderName) {
        this.senderName = senderName;
    }

    public void printSignature() {
        System.out.println("Best regards,");
        System.out.println(senderName);
    }

    protected abstract void sendNotification(String message, String receiver);
}
