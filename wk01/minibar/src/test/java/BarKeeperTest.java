import minibar.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BarKeeperTest {


    Stock stock = new Stock(5);
    Guest guest = new Guest(3);
    Barkeeper keeper = new Barkeeper();


    @Test
    void canServeBeer() throws EmptyStockException {
        try{
            keeper.tapBeer(stock,guest,2);
        }catch (EmptyStockException e){
            fail("Should not fail");
        }
    }

    @Test
    void returnsBeer() throws EmptyStockException {
        assertThat(keeper.tapBeer(stock,guest,1)).isInstanceOf(Beer.class);
    }

    @Test
    void overdrawThrowsExeption() throws EmptyStockException {
        keeper.tapBeer(stock,guest,4);
        assertThatThrownBy(() -> keeper.tapBeer(stock,guest,4)).isInstanceOf(EmptyStockException.class);
    }
}
