package templateengine;

import java.util.function.ObjIntConsumer;

/**
 * Enum states of an enum based state machine. Each state 'consumes' an engine
 * ref and int.
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
enum TemplateState implements ObjIntConsumer<Engine> {
    FORWARDING {
        @Override
        public void accept( Engine e, int c ) {
            //TODO 
            
        }
    }, PREFIX {
        @Override
        public void accept( Engine e, int c ) {
            //TODO 
            
        }

    }, COLLECTKEY {
        @Override
        public void accept( Engine e, int c ) {
            //TODO 
            
        }

    }, POSTFIX {
        @Override
        public void accept( Engine e, int c ) {
            //TODO 
            
        }

    }, ESCAPE {
        @Override
        public void accept( Engine e, int c ) {
            e.flush( c );
            e.changeStateTo( FORWARDING );
        }

    };

}
