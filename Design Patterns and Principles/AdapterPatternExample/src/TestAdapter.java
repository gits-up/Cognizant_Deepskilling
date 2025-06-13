public class TestAdapter {
    public static void main(String[] args) {
        PaymentProcessor processor;

        processor = new StripeAdapter();
        processor.processPayment(500.0);

        processor = new RazorpayAdapter();
        processor.processPayment(1200.0);
    }
}
