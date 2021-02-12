package phonebook;

import static java.lang.String.format;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author urs
 */
public class Phonebook {

    //TODO add field(s)
    HashMap<String, Person> contacts;
    

    public Phonebook() {
        contacts = new HashMap<>();
    }

    public void addEntry( String name, String number ) {
        Person person = new Person(name,number);
        contacts.put(name, person);
        contacts.put(number,person);
        
    }

    public Person searchByName( String name ) {

        return contacts.get(name);

    }

    public Person searchByNumber( String number ) {

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
