// alt + enter to create tests

/*
    Author: Kyunghoon Lee
    CS-320: Module 3 Milestone
    Date: 20 September 2024
 */

// Contact.java class

public class Contact {

    // Instance variables
    private String id;  // max 10 chars, not null. ID needs to remain unique
    private String firstName; // max 10 chars, not null
    private String lastName;  // max 10 chars, not null
    private String phoneNumber;  // 10 digits, not null
    private String address;  // 30 chars or less, not null

    // Default parametrized constructor with input validation
    public Contact(String id, String firstName, String lastName, String phoneNumber, String address) {

        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("ID entry is not valid");
        }

        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("firstName entry is not valid");
        }

        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("lastName entry is not valid");
        }

        if (phoneNumber == null || phoneNumber.length() != 10) {
            throw new IllegalArgumentException("Phone number entry is not valid");
        }

        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address entry is not valid");
        }

        // Assign values if valid
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;

    }

    // Getter functions
    public String getId() {
        return (id);
    }

    public String getFirstName() {
        return (firstName);
    }

    public String getLastName() {
        return (lastName);
    }

    public String getPhoneNumber() {
        return (phoneNumber);
    }

    public String getAddress() {
        return (address);
    }

    // Setter functions with input validation
    public void setFirstName(String firstName) {
        if (firstName.length() > 10 || firstName == null) {
            throw new IllegalArgumentException("firstName entry is not valid");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() > 10 || lastName == null) {
            throw new IllegalArgumentException("lastName entry is not valid");
        }
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 10 || phoneNumber == null) {
            throw new IllegalArgumentException("phoneNumber entry is not valid");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        if (address.length() > 30 || address == null) {
            throw new IllegalArgumentException("Address entry is not valid");
        }
        this.address = address;
    }
}

