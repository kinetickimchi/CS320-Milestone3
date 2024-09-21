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

    // updateContact function for firstName, lastName, phoneNumber, address
    public boolean updateContact(String id, String firstName, String lastName, String phoneNumber, String address) {
        for (Contact contact : list) {
            if (contact.getId().equalsIgnoreCase(id)) {
                if (firstName != null) {
                    contact.setFirstName(firstName);
                }
                if (lastName != null) {
                    contact.setLastName(lastName);
                }
                if (phoneNumber != null) {
                    contact.setPhoneNumber(phoneNumber);
                }
                if (address != null) {
                    contact.setAddress(address);
                }
                return true;
            }
        }
        return false;  // if ID match is not found
    }
}
