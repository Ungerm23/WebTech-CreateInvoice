package htw.berlin.webtech.CreateInvoice.persistence;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "customer")
public class CustomerEntity {

    @Id
    //sorgt dafür, dass nummerischer Wert erzeugt wird, der um 1 hochzählt, sobald neuer Datensatz hinzugefügt wird
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "birthday")
    private LocalDate birthday;

    public CustomerEntity(String firstName, String lastName, String address, String state, LocalDate birthday) {
        //ID im Konstruktor nicht notwendig, da diese von Datenbank erzeugt werden soll
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.state = state;
        this.birthday = birthday;
    }

    //public wäre hier auch möglich, aber nicht notwendig, daher geringste Sichtbarkeit wählen --> protected
    protected CustomerEntity() {}

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
