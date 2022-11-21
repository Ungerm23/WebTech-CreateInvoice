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

    @GetMapping(path = "/api/v1/customer")
    public ResponseEntity<List<Customer>> fetchCustomer() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping(path = "/api/v1/customer/{id}")
    public ResponseEntity<Customer> fetchCustomerById(@PathVariable Long id) {
        var customer = customerService.findById(id);
        //wenn customer nicht null, dann gib customer und ok zurück, falls null gib 404 zurück
        return customer != null? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/customer")
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerManipulationRequest request) throws URISyntaxException {
        var customer = customerService.create(request);
        URI uri = new URI("/api/v1/customer/" + customer.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody CustomerManipulationRequest request) {
        var customer = customerService.update(id, request);
        return customer != null? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/customer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        boolean successful = customerService.deleteById(id);
        //Rückgabe von ok, wenn löschen geklappt hat, notfound, wenn keine Ressource zur ID gefunden wurde
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
