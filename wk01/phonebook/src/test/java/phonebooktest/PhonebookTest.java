package phonebooktest;

import phonebook.BookEntry;
import phonebook.Phonebook;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author urs
 */
public class PhonebookTest {

    Phonebook phonebook;

    @BeforeEach
    void setUp() {
        phonebook = new Phonebook();
    }

    @Test
    public void phonebookSearchByNameNotFound() {
        assertThat(phonebook.searchByName("Jukka"))
                .as("Person is not present in the list")
                .isNull();
    }

    @Test
    public void phonebookAddsEntry() {
        phonebook.addEntry("Pekka", "040-123456");
        assertThat(phonebook.searchByName("Pekka"))
                .as("An added person, phone number should be found")
                .contains("Pekka");
    }

    @Test
    public void phonebookSearchByNumber() {
        phonebook.addEntry("Pekka", "040-123456");
        assertThat(phonebook.searchByNumber("040-123456"))
                .as("search by number should return person's name")
                .contains("Pekka");
    }

    @Test
    public void phonebookSearchByNumberNotFound() {
        assertThat(phonebook.searchByNumber("02-444123"))
                .as("search for number not present should return null")
                .isNull();
    }

    @Test
    public void phonebookSearchAddress(){
        phonebook.addEntry( "Pekka", "040-123456" );
        phonebook.addAddress( "Pekka", "Hulsterweg 6, Venlo" );
        assertThat(phonebook.searchByName( "Pekka" ))
                .as("after add, parts of the address required")
                .contains( "Hulsterweg 6", "Venlo" );
    }

    @Test
    public void phonebookDeletesEntry() {
        phonebook.addEntry("Pekka", "040-123456");
        phonebook.deleteEntry("Pekka");
        assertThat(phonebook.searchByName("Pekka")).isNull();
    }
}