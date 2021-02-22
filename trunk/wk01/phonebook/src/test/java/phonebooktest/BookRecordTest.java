package phonebooktest;

import org.junit.jupiter.api.Test;
import phonebook.BookRecord;
import static org.assertj.core.api.Assertions.*;


public class BookRecordTest {

    BookRecord bookRecord =new BookRecord("Kestutis", "1234567890");

    @Test
    void getNameTest() {
        assertThat(bookRecord.getName()).isEqualTo("Kestutis");
    }

    @Test
    void getAddressNotSetTest() {
        assertThat(bookRecord.getAddress()).isNull();
    }

    @Test
    void getPhoneNumberTest() {
        assertThat(bookRecord.getPhoneNumber()).isEqualTo("1234567890");
    }

    @Test
    void setAddressTest() {
        bookRecord.setAddress("Sedulinos 55-2");
        assertThat(bookRecord.getAddress()).isEqualTo("Sedulinos 55-2");
    }
}
