import minibar.EmptyStockException;
import minibar.Stock;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StockTest {

    Stock stock = new Stock(5);

    @Test
    void canDrawBeer() throws EmptyStockException {
        try{
            stock.draw(2);
        }catch (EmptyStockException e){
            fail("Should not fail");
        }
    }

    @Test
    void getLeftTest() throws EmptyStockException {
        stock.draw(4);
        assertThat(stock.getLeft()).isEqualTo(1);
    }

    @Test
    void overdrawThrowsExeption() throws EmptyStockException {
        stock.draw(4);
        assertThatThrownBy(() -> stock.draw(6)).isInstanceOf(EmptyStockException.class);
    }


}
