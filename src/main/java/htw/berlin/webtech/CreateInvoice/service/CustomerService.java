package htw.berlin.webtech.CreateInvoice.service;

import htw.berlin.webtech.CreateInvoice.persistence.CustomerEntity;
import htw.berlin.webtech.CreateInvoice.persistence.CustomerRepository;
import htw.berlin.webtech.CreateInvoice.web.api.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll(){
        List<CustomerEntity> customers = customerRepository.findAll();
        return customers.stream()
                .map(customerEntity -> new Customer(
                        customerEntity.getId(),
                        customerEntity.getFirstName(),
                        customerEntity.getLastName(),
                        customerEntity.getAddress(),
                        customerEntity.getState(),
                        customerEntity.getBirthday()
                ))
                .collect(Collectors.toList());
    }

}
