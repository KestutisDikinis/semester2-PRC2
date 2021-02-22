import minibar.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


public class GuestTest {
    Stock stock = new Stock(10);
    Guest guest = new Guest(5);

    @Test
    void canDrinkBeer() throws EmptyStockException {
        guest.drink(stock.draw(1));
        assertThat(guest.getAlreadyConsumed()).isEqualTo(1);
    }

    @Test
    void guestIsFull() {
        Beer beer = new Beer(5);
        guest.drink(beer);
        assertThatThrownBy(() -> guest.drink(beer)).isInstanceOf(DrunkenException.class);
    }
}
