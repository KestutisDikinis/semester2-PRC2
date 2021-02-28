/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstmock;

import java.util.Scanner;

/**
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 * @author Linda Urselmans
 */
public class Business {

    private final Printer printer;
    private final Scanner scanner;

    Business( Printer printer, Scanner scanner ) {
        this.printer = printer;
        this.scanner = scanner;
    }

    /**
     * calculates the price of printing: number of characters times the price
     * @param price of printing
     */
    double computePrintingCost(double price){
        //TODO calculate price and return it
        throw new java.lang.UnsupportedOperationException("work() Not supported yet.");
    }

    /**
     * Do some work with input.
     *
     * @param input to work with
     */
    void work( String input ) {
        //TODO print "Hello" plus input
        throw new java.lang.UnsupportedOperationException("work() Not supported yet."); 
    }

    void useScanner() {
        printer.printLn( scanner.nextLine() );
    }

}
