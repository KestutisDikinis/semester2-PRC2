package minibar;

/**
 * This class represent a typical guest of a pub. He / she want drink beer and
 * can be drunken.
 *
 * @author Pia Erbrath
 */
public class Guest {

    //TODO  15 implement Guest fields, getters and setters.
    double capasity;
    double alreadyConsumed;

    public Guest(double capasity) {
        this.capasity = capasity;
    }

    /**
     * *
     * Drinks a beer, optionally get drunk, Hickup.
     *
     * @param beer to consume
     * @throws DrunkenException when overfilled.
     */
    public Guest drink( Beer beer ) throws DrunkenException {
        //TODO 16 implement Guest.drink
        if(alreadyConsumed + beer.getVolume() > capasity){
            throw new DrunkenException();
        }
        alreadyConsumed += beer.getVolume();
        return this;
    }

    public double getAlreadyConsumed() {
        return alreadyConsumed;
    }
}
