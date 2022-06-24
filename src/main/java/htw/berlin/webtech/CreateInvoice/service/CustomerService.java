package htw.berlin.webtech.CreateInvoice.service;

import htw.berlin.webtech.CreateInvoice.persistence.CustomerEntity;
import htw.berlin.webtech.CreateInvoice.persistence.CustomerRepository;
import htw.berlin.webtech.CreateInvoice.web.api.Customer;
import htw.berlin.webtech.CreateInvoice.web.api.CustomerManipulationRequest;
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
                .map(customerEntity -> transformEntity(customerEntity))
                .collect(Collectors.toList());
    }

    public Customer findById(Long id) {
        var customerEntity = customerRepository.findById(id);       //findById hat Option, dass Rückgabewert auch null sein kein
        return customerEntity.isPresent()? transformEntity(customerEntity.get()) :null; //hier somit erst geschaut, ob Entity null, falls nicht dann transformiere
    }                                                                                   //ansonsten gib null zurück

    public Customer create(CustomerManipulationRequest request) {
        var customerEntity = new CustomerEntity(request.getFirstName(), request.getLastName(), request.getAddress(),
                request.getState(), request.getBirthday());
        customerEntity = customerRepository.save(customerEntity);
        return transformEntity(customerEntity);
    }

    public Customer update(Long id, CustomerManipulationRequest request) {
        var customerEntityOptional = customerRepository.findById(id);
        if (customerEntityOptional.isEmpty()) {
            return null;
        }

        var customerEntity = customerEntityOptional.get();
        customerEntity.setFirstName(request.getFirstName());
        customerEntity.setLastName(request.getLastName());
        customerEntity.setAddress(request.getAddress());
        customerEntity.setState(request.getState());
        customerEntity.setBirthday(request.getBirthday());
        customerEntity = customerRepository.save(customerEntity);

        return transformEntity(customerEntity);
    }

    public boolean deleteById(Long id) {
        if (!customerRepository.existsById(id)) {
            return false;
        }

        customerRepository.deleteById(id);
        return true;
    }

    private Customer transformEntity (CustomerEntity customerEntity) {
        return new Customer(
                customerEntity.getId(),
                customerEntity.getFirstName(),
                customerEntity.getLastName(),
                customerEntity.getAddress(),
                customerEntity.getState(),
                customerEntity.getBirthday()
        );
    }

}
