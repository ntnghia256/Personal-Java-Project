package abstract_property;

public class EmailNotification extends Notification {
    public EmailNotification(String senderName) {
        super(senderName);
    }

    @Override
    public void sendNotification(String message, String receiver) {
        System.out.println("Sending email to " + receiver);
        System.out.println("Message: " + message);
        super.printSignature();
    }
}
