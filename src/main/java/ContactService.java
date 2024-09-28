// alt + enter to create tests

/*
    Author: Kyunghoon Lee
    CS-320: Module 3 Milestone
    Date: 20 September 2024
 */

// ContactService.java class

import java.util.ArrayList;

public class ContactService {

    ArrayList<Contact> list = new ArrayList<Contact>();

    // addContact function (IDs have to be unique)
    public boolean addContact(Contact contact) {  // Create Contact and pass contact object
        for (Contact c : list) {  // for each contact c in the list
            if (contact.getId().equalsIgnoreCase(c.getId())) {  // if a matching contact ID is found
                return false;  // duplicate ID, do not add
            }
        }
        // if a match does not exist
        list.add(contact);
        return true;
    }

    // deleteContact function
    public boolean deleteContact(String id) {
        return list.removeIf(contact -> contact.getId().equalsIgnoreCase(id));
    }

    // Separate functions to update fields, to only take in the required information
    public boolean updateContactFirstName(String id, String firstName) {
        for (Contact contact : list) {
            if (contact.getId().equalsIgnoreCase(id)) {
                if (firstName != null && firstName.length() <= 10) {
                    contact.setFirstName(firstName);
                }
            }
        }
        return true; // if id match is not found
    }

    public boolean updateContactLastName(String id, String lastName) {
        for (Contact contact : list) {
            if (contact.getId().equalsIgnoreCase(id)) {
                if (lastName != null && lastName.length() <= 10) {
                    contact.setLastName(lastName);
                }
            }
        }
        return true; // if id match is not found
    }

    public boolean updateContactPhoneNumber(String id, String phoneNumber) {
        for (Contact contact : list) {
            if (contact.getId().equalsIgnoreCase(id)) {
                if (phoneNumber != null && phoneNumber.length() == 10 && phoneNumber.matches("\\d+")) {
                    contact.setPhoneNumber(phoneNumber);
                }
            }
        }
        return true; // if id match is not found
    }

    public boolean updateContactAddress(String id, String address) {
        for (Contact contact : list) {
            if (contact.getId().equalsIgnoreCase(id)) {
                if (address != null && address.length() <= 30) {
                    contact.setAddress(address);
                }
            }
        }
        return true; // if id match is not found
    }
}
