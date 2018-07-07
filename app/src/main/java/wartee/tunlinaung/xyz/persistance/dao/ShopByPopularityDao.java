package wartee.tunlinaung.xyz.persistance.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import wartee.tunlinaung.xyz.data.vo.ShopByDistanceVO;
import wartee.tunlinaung.xyz.data.vo.ShopByPopularityVO;

@Dao
public interface ShopByPopularityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertShopByPopularity(ShopByPopularityVO... shopByPopularityVOs);

    @Query("SELECT * FROM shop_by_popularity")
    List<ShopByPopularityVO> getAllShopsByPopularity();

    @Query("SELECT * FROM shop_by_popularity WHERE shop_by_popularity_id= :shopByPopularityId")
    ShopByPopularityVO getShopByPopularityById(String shopByPopularityId);

    @Query("SELECT * FROM shop_by_popularity WHERE shop_by_popularity_id= :shopByPopularityId")
    LiveData<ShopByPopularityVO> getShopByPopularityByIdLD(String shopByPopularityId);

}
