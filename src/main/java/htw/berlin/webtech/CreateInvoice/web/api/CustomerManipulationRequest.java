package htw.berlin.webtech.CreateInvoice.web.api;

import java.time.LocalDate;

public class CustomerManipulationRequest {

    private String firstName;
    private String lastName;
    private String address;
    private String state;
    private LocalDate birthday;

    public CustomerManipulationRequest(String firstName, String lastName, String address, String state, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.state = state;
        this.birthday = birthday;
    }

    public CustomerManipulationRequest() {}

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
