package wartee.tunlinaung.xyz.persistance.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import wartee.tunlinaung.xyz.data.vo.FoodVO;
import wartee.tunlinaung.xyz.data.vo.MealShopVO;
import wartee.tunlinaung.xyz.data.vo.RestaurantVO;

@Dao
public interface RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertRestaurant(RestaurantVO... restaurantVOs);

    @Query("SELECT * FROM restaurant")
    List<RestaurantVO> getAllRestaurants();

    @Query("SELECT * FROM restaurant WHERE shop_id = :shopId")
    RestaurantVO getRestaurantById(String shopId);

    @Query("SELECT * FROM restaurant WHERE shop_id = :shopId")
    LiveData<RestaurantVO> getRestaurantsByIdLD(String shopId);

}
