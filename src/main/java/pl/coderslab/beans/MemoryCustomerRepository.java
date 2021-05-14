package pl.coderslab.beans;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Component
public class MemoryCustomerRepository implements CustomerRepository{
    private final CustomerLogger customerLogger;
    private final List<Customer> customers = new ArrayList<>();

    public MemoryCustomerRepository(CustomerLogger customerLogger) {
        this.customerLogger = customerLogger;
    }

    @Override
    public void addCustomer(Customer customer) {
        if(!customers.contains(customer)){
            customerLogger.log();
            customers.add(customer);
        }
    }

    @Override
    public void removeCustomer(Customer customer) {
        customerLogger.log();
        customers.remove(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return List.copyOf(customers);
    }
}
