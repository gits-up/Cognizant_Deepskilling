public class StripeAdapter implements PaymentProcessor {
    private StripePayment stripe;

    public StripeAdapter() {
        stripe = new StripePayment();
    }

    @Override
    public void processPayment(double amount) {
        stripe.payViaStripe(amount);
    }
}
