// THIS NEEDS TO BE CHECKED FOR ACCURACY: 20240921
// Check all the test cases

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("123456", "John", "Doe", "1234567890", "123 Main Street");
        assertTrue(contactService.addContact(contact));
        assertEquals(1, contactService.list.size()); // Check that the contact was added
        assertFalse(contactService.addContact(contact)); // Adding the same contact should return false
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("123456", "John", "Doe", "1234567890", "123 Main Street");
        contactService.addContact(contact);
        assertTrue(contactService.deleteContact("123456"));
        assertFalse(contactService.deleteContact("123456")); // Already deleted
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("123456", "John", "Doe", "1234567890", "123 Main Street");
        contactService.addContact(contact);

        // Update all fields
        assertTrue(contactService.updateContact("123456", "Jane", "Smith", "0987654321", "456 Elm Street"));
        Contact updatedContact = contactService.list.get(0);

        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhoneNumber());
        assertEquals("456 Elm Street", updatedContact.getAddress());

        // Test updating with null values (should not change existing data)
        assertTrue(contactService.updateContact("123456", null, null, null, null));
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhoneNumber());
        assertEquals("456 Elm Street", updatedContact.getAddress());

        // Test invalid contact ID
        assertFalse(contactService.updateContact("999999", "Tom", "Brown", "0123456789", "789 Maple Avenue"));
    }

    @Test
    public void testDeleteNonExistentContact() {
        assertFalse(contactService.deleteContact("nonexistentID"));
    }
}