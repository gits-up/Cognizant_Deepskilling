public class TestDecorator {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();

        notifier = new SMSNotifierDecorator(notifier);
        notifier = new SlackNotifierDecorator(notifier);

        notifier.send("You have a new notification!");
    }
}
