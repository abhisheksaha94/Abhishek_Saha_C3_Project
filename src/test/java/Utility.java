import java.time.LocalTime;

import static org.mockito.Mockito.spy;

public class Utility {
    RestaurantService service = new RestaurantService();
    Restaurant restaurant;

    public Restaurant addNewResturantWithItems(String resturantName, boolean mockingRequired){
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");

        if(mockingRequired){
            restaurant =spy(new Restaurant(resturantName,"Chennai",openingTime,closingTime));
        }
        else
            restaurant = service.addRestaurant(resturantName,"Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);
        return restaurant;
    }

    public Restaurant addNewResturantWithoutItems(String resturantName, boolean mockingRequired){
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");

        if(mockingRequired){
            restaurant =spy(new Restaurant(resturantName,"Chennai",openingTime,closingTime));
        }
        else
            restaurant = service.addRestaurant(resturantName,"Chennai",openingTime,closingTime);
        return restaurant;
    }
}
