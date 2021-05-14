package pl.coderslab;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.beans.Customer;
import pl.coderslab.beans.MemoryCustomerRepository;
import pl.coderslab.beans.SimpleCustomerLogger;

public class SpringDiApplication {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            SimpleCustomerLogger simpleCustomerLogger = context.getBean(SimpleCustomerLogger.class);
            simpleCustomerLogger.log();

            MemoryCustomerRepository memoryCustomerRepository = context.getBean(MemoryCustomerRepository.class);
            memoryCustomerRepository.addCustomer(new Customer(1, "Mateusz", "Górczyński"));
            System.out.println(memoryCustomerRepository.getAllCustomers().toString());
        }
    }
}
