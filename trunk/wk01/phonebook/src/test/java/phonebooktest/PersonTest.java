package phonebooktest;

import org.junit.jupiter.api.Test;
import phonebook.Person;
import static org.assertj.core.api.Assertions.*;


public class PersonTest {

    Person person =new Person("Kestutis", "1234567890");

    @Test
    void getNameTest() {
        assertThat(person.getName()).isEqualTo("Kestutis");
    }

    @Test
    void getAddressNotSetTest() {
        assertThat(person.getAddress()).isNull();
    }

    @Test
    void getPhoneNumberTest() {
        assertThat(person.getPhoneNumber()).isEqualTo("1234567890");
    }

    @Test
    void setAddressTest() {
        person.setAddress("Sedulinos 55-2");
        assertThat(person.getAddress()).isEqualTo("Sedulinos 55-2");
    }
}
