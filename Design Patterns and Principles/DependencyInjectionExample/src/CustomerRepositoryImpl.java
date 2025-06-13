public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        if (id == 1) {
            return "Customer ID: 1, Name: Ram";
        } else if (id == 2) {
            return "Customer ID: 2, Name: Rahul";
        } else {
            return "Customer not found!";
        }
    }
}
