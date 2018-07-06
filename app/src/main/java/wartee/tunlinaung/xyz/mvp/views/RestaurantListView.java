package wartee.tunlinaung.xyz.mvp.views;

public interface RestaurantListView extends BaseView {

    void launchRestaurantDetails(String restaurantId);

    void launchFoodDetailsScreen(String foodId);

}
