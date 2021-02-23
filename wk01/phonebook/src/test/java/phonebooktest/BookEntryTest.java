
package phonebooktest;

import org.junit.jupiter.api.Test;
import phonebook.BookEntry;

import static org.assertj.core.api.Assertions.*;


public class BookEntryTest {

    BookEntry bookEntry = new BookEntry("Kestutis", "1234567890");

    @Test
    public void getNameTest() {
        assertThat(bookEntry.getName()).isEqualTo("Kestutis");
    }

    @Test
    public void getAddressNotSetTest() {
        assertThat(bookEntry.getAddress()).isNull();
    }

    @Test
    public void getPhoneNumberTest() {
        assertThat(bookEntry.getPhoneNumber()).contains("1234567890");
    }

    @Test
    public void setAddressTest() {
        bookEntry.setAddress("Sedulinos 55-2");
        assertThat(bookEntry.getAddress()).isEqualTo("Sedulinos 55-2");
    }
}