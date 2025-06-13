public class TestStrategy {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment("Ram", "1234-5678-9876-5432"));
        context.pay(2500.00);

        System.out.println("---");

        context.setPaymentStrategy(new PayPalPayment("ram@gmail.com"));
        context.pay(1200.50);
    }
}
