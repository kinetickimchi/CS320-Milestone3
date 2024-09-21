// THIS NEEDS TO BE CHECKED FOR ACCURACY: 20240921
// Check all the test cases

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    public void testValidContactCreation() {
        // Valid contact creation test
        Contact contact = new Contact("123456", "John", "Doe", "1234567890", "123 Main Street");
        assertEquals("123456", contact.getId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    public void testInvalidId() {
        // Test invalid ID (null or length > 10)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testInvalidFirstName() {
        // Test invalid first name (null or length > 10)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", null, "Doe", "1234567890", "123 Main Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "Johnathaasdf", "Doe", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testInvalidLastName() {
        // Test invalid last name (null or length > 10)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "John", null, "1234567890", "123 Main Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "John", "JohnsonSmith", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testInvalidPhoneNumber() {
        // Test invalid phone number (null, length != 10, non-digit)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "John", "Doe", null, "123 Main Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "John", "Doe", "123456", "123 Main Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "John", "Doe", "12345abcd0", "123 Main Street");
        });
    }

    @Test
    public void testInvalidAddress() {
        // Test invalid address (null or length > 30)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "John", "Doe", "1234567890", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "John", "Doe", "1234567890", "This address is definitely more than 30 characters long");
        });
    }

    @Test
    public void testSetters() {
        // Test setters
        Contact contact = new Contact("123456", "John", "Doe", "1234567890", "123 Main Street");

        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());

        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());

        contact.setPhoneNumber("0987654321");
        assertEquals("0987654321", contact.getPhoneNumber());

        contact.setAddress("456 Elm Street");
        assertEquals("456 Elm Street", contact.getAddress());
    }
}