/*
    Author: Kyunghoon Lee
    CS-320: Module 3 Milestone
    Date: 21 September 2024
 */

// Unit tests for ContactService.java

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;  // For testing order setup
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
    private ContactService contactService;  // Creates ContactService instance for testing

    @BeforeEach
    // Run ContactService before executing each test
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    @DisplayName("Testing addContact")
    // Test addContact function
    public void testAddContact() {
        Contact contact = new Contact("12345678", "Lebron", "James", "1234567890", "123 Main Street");
        assertTrue(contactService.addContact(contact));  // Does adding the contact return true?
        assertEquals(1, contactService.list.size()); // Has the contact been added to the list?
        assertFalse(contactService.addContact(contact)); // Does adding the same contact (duplicate id) return false?
    }

    @Test
    @DisplayName("Testing deleteContact")
    // Test deleteContact function
    public void testDeleteContact() {
        Contact contact = new Contact("12345678", "Lebron", "James", "1234567890", "123 Main Street");
        contactService.addContact(contact); // Add the contact object
        assertTrue(contactService.deleteContact("12345678"));  // Does this remove the added contact?
        assertFalse(contactService.deleteContact("12345678")); // Does removing a contact that has been deleted already return false?
    }

    @Test
    @DisplayName("Testing deleteContact with nonexistent ID")
    // Test deleteContact with nonexistent ID
    public void testDeleteNonExistentContact() {
        assertFalse(contactService.deleteContact("fakeID"));
    }

    @Test
    @DisplayName("Test updateContact")
    // Test for updating contact fields
    public void testUpdateContact() {
        Contact contact = new Contact("12345678", "Lebron", "James", "1234567890", "123 Main Street");
        contactService.addContact(contact);  // Add the contact object

        // Update firstName, lastName, phoneNumber, address fields. ID is unique and should stay the same
        assertTrue(contactService.updateContact("12345678", "Kevin", "Durant", "0987654321", "234 Main Street"));
        Contact updatedContact = contactService.list.get(0);  // Pull the contact again with updated fields

        // Do the updated fields match the expected values?
        assertEquals("Kevin", updatedContact.getFirstName());
        assertEquals("Durant", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhoneNumber());
        assertEquals("234 Main Street", updatedContact.getAddress());

    }
}