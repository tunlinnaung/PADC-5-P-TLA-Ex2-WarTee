package wartee.tunlinaung.xyz.network;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import wartee.tunlinaung.xyz.network.responses.FoodResponse;
import wartee.tunlinaung.xyz.network.responses.RestaurantResponse;

public interface WarTeeApi {

    @FormUrlEncoded
    @POST("v1/GetWarDee.php")
    Observable<FoodResponse> getFoods(@Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("v1/GetMealShop.php")
    Observable<RestaurantResponse> getRestaurants(@Field("access_token") String accessToken);

}
