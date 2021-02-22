package phonebook;

import static java.lang.String.format;
import java.util.HashMap;

/**
 *
 * @author urs
 */
public class Phonebook {

    HashMap<String, BookRecord> contacts;
    

    public Phonebook() {
        contacts = new HashMap<>();
    }

    public void addEntry( String name, String number ) {
        BookRecord bookRecord = new BookRecord(name,number);
        contacts.put(name, bookRecord);
        contacts.put(number, bookRecord);
        
    }

    public BookRecord searchByName(String name ) {

        return contacts.get(name);

    }

    public BookRecord searchByNumber(String number ) {

        return contacts.get(number);

    }

    public void addAddress( String name, String address ) {
        contacts.get(name).setAddress(address);
        
    }

    public void deleteEntry( String name ) {

        String number = contacts.get(name).getPhoneNumber();
        contacts.remove(name);
        contacts.remove(number);
    }

}
