import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;

class RestaurantTest {
    Restaurant restaurant;
    Utility utility = new Utility();
    //REFACTOR ALL THE REPEATED LINES OF CODE

    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //-------FOR THE 2 TESTS BELOW, YOU MAY USE THE CONCEPT OF MOCKING, IF YOU RUN INTO ANY TROUBLE
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){

        restaurant = utility.addNewResturantWithItems("Amelie's cafe", true);
        LocalTime currentTime1 = LocalTime.parse("10:30:00");
        LocalTime currentTime2 = LocalTime.parse("22:00:00");
        LocalTime currentTime3 = LocalTime.parse("12:12:12");
        Mockito.when(restaurant.getCurrentTime()).thenReturn(currentTime1, currentTime2, currentTime3);
        assertTrue(restaurant.isRestaurantOpen());
        assertTrue(restaurant.isRestaurantOpen());
        assertTrue(restaurant.isRestaurantOpen());
    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
        restaurant = utility.addNewResturantWithItems("Amelie's cafe", true);
        LocalTime currentTime1 = LocalTime.parse("10:29:29");
        LocalTime currentTime2 = LocalTime.parse("22:00:01");
        Mockito.when(restaurant.getCurrentTime()).thenReturn(currentTime1, currentTime2);
        assertFalse(restaurant.isRestaurantOpen());
        assertFalse(restaurant.isRestaurantOpen());

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){

        restaurant = utility.addNewResturantWithItems("Amelie's cafe", false);

        int initialMenuSize = restaurant.getMenu().size();
        restaurant.addToMenu("Sizzling brownie",319);
        assertEquals(initialMenuSize+1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {

        restaurant = utility.addNewResturantWithItems("Amelie's cafe", false);

        int initialMenuSize = restaurant.getMenu().size();
        restaurant.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize-1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {

        restaurant = utility.addNewResturantWithItems("Amelie's cafe", false);

        assertThrows(itemNotFoundException.class,
                ()->restaurant.removeFromMenu("French fries"));
    }
    //<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
}