package htw.berlin.webtech.CreateInvoice.web;

import htw.berlin.webtech.CreateInvoice.web.api.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonRestController {

    private List<Person> persons;

    public PersonRestController() {
        this.persons = new ArrayList<>();
        persons.add(new Person(1, "Max", "Mustermann", "Berliner Allee 177", "13.02.1998"));
        persons.add(new Person(2, "Martina", "Meier", "Treskowalle 4", "25.07.1988"));
    }

    @GetMapping(path = "/api/v1/persons")
    public ResponseEntity<List<Person>> fetchPersons() {
        return ResponseEntity.ok(persons);
    }

}
