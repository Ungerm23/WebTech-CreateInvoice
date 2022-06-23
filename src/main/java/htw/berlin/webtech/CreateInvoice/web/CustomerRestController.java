package htw.berlin.webtech.CreateInvoice.web;

import htw.berlin.webtech.CreateInvoice.persistence.CustomerEntity;
import htw.berlin.webtech.CreateInvoice.persistence.CustomerRepository;
import htw.berlin.webtech.CreateInvoice.service.CustomerService;
import htw.berlin.webtech.CreateInvoice.web.api.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerRestController {

    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/api/v1/customer")
    public ResponseEntity<List<Customer>> fetchCustomers() {
        return ResponseEntity.ok(customerService.findAll());
    }



}
