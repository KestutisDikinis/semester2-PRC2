package sampleentities;

import deconstructorregistry.Deconstructor;

/**
 * Incomplete Deconstructor. To be replaced by generated one.
 *
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 */
public class StudentDeconstructor extends Deconstructor<Student> {

    private StudentDeconstructor() {

    }

    static {

        Deconstructor.register( Student.class, new StudentDeconstructor() );
    }

    @Override
    public Object[] deconstruct( Student e ) {
        return new Object[]{
            e.getSnummer(),
            e.getLastname(),
            e.getTussenvoegsel(),
            e.getFirstname(),
            e.getDob(),
            e.getCohort(),
            e.getEmail(),
            e.getGender(),
            e.getStudent_class(),
            e.getActive()
        };
    }
}
