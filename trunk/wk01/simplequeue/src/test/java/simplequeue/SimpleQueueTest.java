package simplequeue;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandehombergh@gmail.com}
 */
public class SimpleQueueTest {


    @Test
    void queueIsGeneric(){
        SimpleQueue<String> queue = new SimpleQueue<>();
        SimpleQueue<Integer> queue2 = new SimpleQueue<>();
    }

    @Test
    void emptyTest(){
        SimpleQueue<String> queue = new SimpleQueue<>();
        assertThat(queue.isEmpty()).isTrue();
    }

    @Test
    void peektest(){
        SimpleQueue<String> queue = new SimpleQueue<>();
        SimpleQueue<Integer> queue2 = new SimpleQueue<>();
        String expectedString = "Kestutis";
        queue.put(expectedString);
        queue2.put(200);
        assertThat(queue.peek()).isSameAs( expectedString );
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(queue.peek()).isEqualTo(expectedString);
            softAssertions.assertThat(queue2.peek()).isEqualTo(200);
        });
    }

    @Test
    void takeTest(){
        SimpleQueue<String> queue = new SimpleQueue<>();
        String expected = "Kestutis";
        queue.put(expected);
        String taken = queue.take();

        assertThat(taken).isEqualTo(expected);
    }

    @Test
    void multipleTest() {
        SimpleQueue<String> queue = new SimpleQueue<>();
        String[] values= { "Hello", "World", "And", "Some", "Bla", "Di", "Bla" };
        for(String value : values){
            queue.put(value);
        }
        ArrayList<String> returns = new ArrayList<>();
        while (!queue.isEmpty()){
            returns.add(queue.take());
        }
        assertThat(returns).containsExactly(values);
    }

    @Test
    void multipleTestWithIterator(){
        SimpleQueue<String> queue = new SimpleQueue<>();
        String[] values= { "Hello", "World", "And", "Some", "Bla", "Di", "Bla" };
        for (String value : values){
            queue.put(value);
        }
        for(String string : queue){
            System.out.println(string);
        }

        assertThat( queue ).containsExactly( values );
    }

    @Test
    void throwableTestPeek(){
        SimpleQueue<String> queue = new SimpleQueue<>();
        ThrowableAssert.ThrowingCallable code =()->{queue.peek();};
        assertThatThrownBy(code);
    }

    @Test
    void throwableTestTake(){
        SimpleQueue<String> queue = new SimpleQueue<>();
        ThrowableAssert.ThrowingCallable code =()->{queue.take();};
        assertThatThrownBy(code);
    }

}
