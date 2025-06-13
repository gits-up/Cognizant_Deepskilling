public class RazorpayAdapter implements PaymentProcessor {
    private RazorpayPayment razorpay;

    public RazorpayAdapter() {
        razorpay = new RazorpayPayment();
    }

    @Override
    public void processPayment(double amount) {
        razorpay.makeRazorpayPayment(amount);
    }
}
