package deconstructorregistry;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import sampleentities.Student;

/**
 * Self registering Deconstructor.
 *
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 * @param <E> type to deconstruct.
 */
public abstract class Deconstructor<E> {

    private static final ConcurrentMap<Class<?>, Deconstructor<?>> register = new ConcurrentHashMap<>();

    public static <E> Deconstructor<E> forType( Class<E> et ) {
        //TODO if register dos not contain et, load the class.
        return (Deconstructor<E>) register.get( et );
    }

    /**
     * Load a deconstructor class name from entity type name by appending "Deconstructor".
     * @param <E> of the entity
     * @param forEntity the actual type
     */
    private static <E> void loadDeconstructorClass( Class<E> forEntity ) {
        //TODO load the 
    }

    protected static void register( Class<?> et, Deconstructor<?> dec ) {
        //TODO add the new Deconstructor to register
        
    }

    /**
     * Method to be implemented by (potentially generated) leaf deconstructors.
     *
     * @param entity to deconstruct
     * @return field values in array
     */
    public abstract Object[] deconstruct( E entity );

}
