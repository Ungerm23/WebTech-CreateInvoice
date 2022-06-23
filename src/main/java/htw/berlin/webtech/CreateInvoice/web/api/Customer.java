package htw.berlin.webtech.CreateInvoice.web.api;

import java.time.LocalDate;

public class Customer {

    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String state;
    private LocalDate birthday;

    public Customer(long id, String firstName, String lastName, String address, String state, LocalDate birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.state = state;
        this.birthday = birthday;
    }


    LocalDate date = LocalDate.of(1998, 2, 13);


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
