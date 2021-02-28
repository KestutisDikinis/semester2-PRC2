package myfirstmock;

/**
 * Simple printer.
 * 
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 * @author Linda Urselmans
 */
public interface Printer {

    void printLn( String print );

    int countCharactersPrinted();
}
