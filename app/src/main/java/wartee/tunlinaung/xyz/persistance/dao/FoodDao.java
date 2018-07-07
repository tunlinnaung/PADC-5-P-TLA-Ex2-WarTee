package wartee.tunlinaung.xyz.persistance.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import wartee.tunlinaung.xyz.data.vo.FoodVO;

@Dao
public interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertFood(FoodVO... foodVOs);

    @Query("SELECT * FROM food")
    List<FoodVO> getAllFoods();

    @Query("SELECT * FROM food WHERE war_dee_id = :warDeeId")
    FoodVO getFoodsById(String warDeeId);

    @Query("SELECT * FROM food WHERE war_dee_id = :warDeeId")
    LiveData<FoodVO> getFoodsByIdLD(String warDeeId);

}
