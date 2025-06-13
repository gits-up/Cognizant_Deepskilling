public class DIExampleTest {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);

        service.displayCustomer(1);
        service.displayCustomer(2);
        service.displayCustomer(999);
    }
}
