package wartee.tunlinaung.xyz.persistance.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import wartee.tunlinaung.xyz.data.vo.ReviewsVO;
import wartee.tunlinaung.xyz.data.vo.ShopByDistanceVO;

@Dao
public interface ShopByDistanceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertShopByDistance(ShopByDistanceVO... shopByDistanceVOs);

    @Query("SELECT * FROM shop_by_distance")
    List<ShopByDistanceVO> getAllShopsByDistance();

    @Query("SELECT * FROM shop_by_distance WHERE shop_by_distance_id= :shopByDistanceId")
    ShopByDistanceVO getShopByDistanceById(String shopByDistanceId);

    @Query("SELECT * FROM shop_by_distance WHERE shop_by_distance_id= :shopByDistanceId")
    LiveData<ShopByDistanceVO> getShopByDistanceByIdLD(String shopByDistanceId);

}
