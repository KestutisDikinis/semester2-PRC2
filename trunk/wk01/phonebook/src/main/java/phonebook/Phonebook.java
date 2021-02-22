package phonebook;

import static java.lang.String.format;

import java.util.HashMap;

/**
 * @author urs
 */
public class Phonebook {

    HashMap<String, BookEntry> contacts;


    public Phonebook() {
        contacts = new HashMap<>();
    }

    public void addEntry(String name, String number) {
        BookEntry bookEntry = new BookEntry(name, number);
        contacts.put(name, bookEntry);
        contacts.put(number, bookEntry);

    }

    public BookEntry searchByName(String name) {

        return contacts.get(name);

    }

    public BookEntry searchByNumber(String number) {

        return contacts.get(number);

    }

    public void addAddress(String name, String address) {
        contacts.get(name).setAddress(address);

    }

    public void deleteEntry(String name) {

        String number = contacts.get(name).getPhoneNumber();
        contacts.remove(name);
        contacts.remove(number);
    }

}
