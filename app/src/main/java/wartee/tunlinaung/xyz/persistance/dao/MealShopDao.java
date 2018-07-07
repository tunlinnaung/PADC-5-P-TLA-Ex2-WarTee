package wartee.tunlinaung.xyz.persistance.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import wartee.tunlinaung.xyz.data.vo.FoodVO;
import wartee.tunlinaung.xyz.data.vo.MatchWarDeeListVO;
import wartee.tunlinaung.xyz.data.vo.MealShopVO;

@Dao
public interface MealShopDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertMealShop(MealShopVO... mealShopVOs);

    @Query("SELECT * FROM meal_shop")
    List<MealShopVO> getAllMealShops();

    @Query("SELECT * FROM meal_shop WHERE meal_shop_id= :mealShopId")
    MealShopVO getMatchMealShopById(String mealShopId);

    @Query("SELECT * FROM meal_shop WHERE meal_shop_id= :mealShopId")
    LiveData<MealShopVO> getMatchMealShopByIdLD(String mealShopId);

}
