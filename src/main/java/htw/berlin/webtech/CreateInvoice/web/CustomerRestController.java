package htw.berlin.webtech.CreateInvoice.web;

import htw.berlin.webtech.CreateInvoice.service.CustomerService;
import htw.berlin.webtech.CreateInvoice.web.api.Customer;
import htw.berlin.webtech.CreateInvoice.web.api.CustomerManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.ResourceBundle;

@RestController
public class CustomerRestController {

    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/api/v1/customers")
    public ResponseEntity<List<Customer>> fetchCustomers() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping(path = "/api/v1/customers/{id}")
    public ResponseEntity<Customer> fetchCustomerById(@PathVariable Long id) {
        var customer = customerService.findById(id);
        //wenn customer nicht null, dann gib customer und ok zurück, falls nicht gib 404 zurück
        return customer != null? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/customers")
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerManipulationRequest request) throws URISyntaxException {
        var customer = customerService.create(request);
        URI uri = new URI("/api/v1/customers/" + customer.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/customers/{id}")
    public ResponseEntity<Customer> updatePerson(@PathVariable Long id, @RequestBody CustomerManipulationRequest request) {
        var customer = customerService.update(id, request);
        return customer != null? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        boolean successful = customerService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
