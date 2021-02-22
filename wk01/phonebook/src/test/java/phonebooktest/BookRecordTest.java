package phonebooktest;

import org.junit.jupiter.api.Test;
import phonebook.BookRecord;
import static org.assertj.core.api.Assertions.*;


public class BookRecordTest {

    BookRecord bookRecord =new BookRecord("Kestutis", "1234567890");

    @Test
    public void getNameTest() {
        assertThat(bookRecord.getName()).isEqualTo("Kestutis");
    }

    @Test
    public void getAddressNotSetTest() {
        assertThat(bookRecord.getAddress()).isNull();
    }

    @Test
    public void getPhoneNumberTest() {
        assertThat(bookRecord.getPhoneNumber()).isEqualTo("1234567890");
    }

    @Test
    public void setAddressTest() {
        bookRecord.setAddress("Sedulinos 55-2");
        assertThat(bookRecord.getAddress()).isEqualTo("Sedulinos 55-2");
    }
}
