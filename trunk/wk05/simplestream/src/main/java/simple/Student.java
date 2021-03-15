package simple;

import java.time.LocalDate;

/**
 * Simple student.
 * To get you project the nice deep green in coverage, test this class.
 * 
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class Student {

    private final int snummmer;
    private final String firstName;
    private final String moulden;
    private final LocalDate born;
    private final Gender gender;

    public Student( int snummer, String firstName, String lastName, LocalDate bd,
            Gender gender ) {
        this.snummmer = snummer;
        this.firstName = firstName;
        this.moulden = lastName;
        this.born = bd;
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.snummmer;
        return hash;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final Student other = ( Student ) obj;
        return this.snummmer == other.snummmer;
    }

    public int getSnummmer() {
        return snummmer;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMoulden() {
        return moulden;
    }

    public LocalDate getBorn() {
        return born;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Student " + "snummmer=" + snummmer + ", " + firstName + ", "
                + moulden + ", born " + born + ", " + gender;
    }

    /**
     *
     * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
     */
    public enum Gender {
        F, M
    }

}
