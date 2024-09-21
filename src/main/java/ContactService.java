// alt + enter to create tests

/*
    Author: Kyunghoon Lee
    CS-320: Module 3 Milestone
    Date: 20 September 2024
 */

// ContactService.java class

import java.util.ArrayList;

public class ContactService {

    private ArrayList<Contact> list = new ArrayList<>();

    // addContact function (IDs have to be unique)
    public boolean addContact(Contact contact) {  // Create Contact and pass contact object
        boolean didAdd = false;  // initialize to false

        // if list is empty, add the contact object to the list, change didAdd to true
        if (list.size() == 0) {
            list.add(contact);
            didAdd = true;
        } else {
            for (Contact c : list) {  // for each contact c in the list
                if (contact.getid().equalsIgnoreCase(c.getid())) {  // if contact ID matches a list entry
                    return didAdd;  // return FALSE
                }
            }
            list.add(contact);  // if matching ID is never found, add contact to list
            didAdd = true;
        }
        return didAdd;
    }

}
