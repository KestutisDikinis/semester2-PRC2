package client;

import java.time.Instant;
import static java.time.Instant.now;
import static java.time.temporal.ChronoUnit.NANOS;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import nl.fontys.sebivenlo.minmaxcollector.MinMaxCollector;
import static nl.fontys.sebivenlo.minmaxcollector.MinMaxCollector.minmax;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandehombergh@gmail.com}
 */
public class Main {

    public static void main( String[] args ) {
        List<String> list = Stream.iterate( 0L, l->l+1 )
                .limit( 20_000_000)
                .map( v ->  makeRandomString())
                .collect( Collectors.toList());
        
        Comparator<String> comp = ( a, b ) -> a.compareTo( b );

        Runnable r1 = () -> {
            String max = list.stream().max( comp ).get();
            String min = list.stream().min( comp ).get();
//            System.out.println( "min="+min+ ", max="+max );
        };

        Runnable r2= () -> {
            Optional<MinMaxCollector.MinMax<String>> mm = list.stream().collect( minmax(comp));
            String max= mm.get().getMax();
            String min= mm.get().getMax();
//            System.out.println( "min="+min+ ", max="+max );
        };

        Runnable r3= () -> {
            String max = list.parallelStream().max( comp ).get();
            String min = list.parallelStream().min( comp ).get();
//            System.out.println( "min="+min+ ", max="+max );
        };

        Runnable r4= () -> {
            Optional<MinMaxCollector.MinMax<String>> mm = list.parallelStream().collect( minmax(comp));
            String max= mm.get().getMax();
            String min= mm.get().getMax();
//            System.out.println( "min="+min+ ", max="+max );
        };

        time( "standard", r1 );
        time( "min-max", r2 );
        time( "standard parallel", r3 );
        time( "min-max parallel", r2 );
        
        /// code is hot, do it again same
        System.out.println( "after hotspot kicks in" );
        time( "standard", r1 );
        time( "min-max", r2 );
        time( "standard parallel", r3 );
        time( "min-max parallel", r4 );
        
        
    }

    private final static Random rnd = new Random( 1234567 );
    private static Base64.Encoder encoder = Base64.getEncoder().withoutPadding();

    private static String makeRandomString() {
        String rs = new String( encoder.encode( ( "" + rnd.nextLong() ).getBytes() ) );
        return rs;
    }

    static void time( String desc, Runnable r ) {
        Instant start = Instant.now();
        r.run();
        Instant end = now();

        long nanos=  start.until(end,NANOS );
        System.out.println( String.format( desc + " time = %,d ns " , nanos ));

    }
}
