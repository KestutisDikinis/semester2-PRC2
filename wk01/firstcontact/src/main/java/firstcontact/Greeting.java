package firstcontact;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandehombergh@gmail.com}
 */
public class Greeting {

    String name;

    public Greeting(String name) {
        this.name = name;
    }


    public String greet() {
        return "Hello "+name;
    }


}