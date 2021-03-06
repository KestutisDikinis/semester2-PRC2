
package enumcalculator;

import java.util.function.IntBinaryOperator;

/**
 * Enum with operations. Example of how to use lambda expressions in an (enum)
 * constructor.
 *
 * @author Pieter van den Hombergh {@code <p.vandenhombergh@fontys.nl>}
 */
public enum Operator {
    //TODO define enum values
    ADD     ("+",(a,b) -> a+b),
    SUBTRACT("-", (a,b) -> a-b),
    MULTIPLY("*", (a,b) -> a*b),
    DIVIDE  ("/", (a,b) -> a/b),
    POWER   ("**", (a,b) -> (int) Math.pow(a,b));

    /**
     * Get the operator using its symbol. This method does a linear search
     * through the values of this enum.
     *
     * @param symbol to search
     * @return operation when found, null otherwise.
     */
    public static Operator get( String symbol ) {
        Operator[] operators = Operator.values();
        for(Operator operator : operators){
            if(operator.getSymbol().equals(symbol)){
                return operator;
            }
        }
        return null;
    }

    /**
     * The operation is a IntBinaryOperator.
     *
     */
    private final IntBinaryOperator computation;
    /**
     * The symbol that identifies the operation.
     */
    private final String symbol;

    /**
     * The constructor to create the Operation instances.
     *
     * @param symbol of this operator
     * @param computation the actual method
     */
    Operator( String symbol, IntBinaryOperator computation ) {
        this.symbol = symbol;
        this.computation = computation;
    }

    /**
     * Execute the calculation.
     *
     * @param a first param
     * @param b second param
     * @return result get the computation.
     */
    public int compute( int a, int b ) {

        return computation.applyAsInt(a,b);
    }

    private String getSymbol() {
        return symbol;
    }
}
