/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.fontys.sebivenlo.library;

import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.List;

/**
 *
 * @author hom
 */
public class BookBusiness {
    
    final LibraryModel lm ;

    public BookBusiness(LibraryModel lm) {
        this.lm = lm;
    }
    
    void business(){
    
    List<Book> bl = lm.getBooks();
        // long form
        Book youngest = bl.stream()
                .max( comparing( Book::getYearOfPublication ) )
                .orElse( DefaultLibrary.NULL_OBJECT_BOOK );
        // short for with declared comparator.
        Comparator<Book> byAge = Comparator.comparing(
                Book::getYearOfPublication );
        Book oldest = bl.stream().min( byAge ).get();

        System.out.println( "oldest = " + oldest );
        System.out.println( "youngest = " + youngest );}
}
