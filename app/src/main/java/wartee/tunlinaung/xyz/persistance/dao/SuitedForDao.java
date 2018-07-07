package wartee.tunlinaung.xyz.persistance.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import wartee.tunlinaung.xyz.data.vo.ShopByPopularityVO;
import wartee.tunlinaung.xyz.data.vo.SuitedForVO;

@Dao
public interface SuitedForDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertSuitedFor(SuitedForVO... suitedForVOs);

    @Query("SELECT * FROM suited_for")
    List<SuitedForVO> getAllSuitedFor();

    @Query("SELECT * FROM suited_for WHERE suited_for_id= :suitedForId")
    SuitedForVO getSuitedForById(String suitedForId);

    @Query("SELECT * FROM suited_for WHERE suited_for_id= :suitedForId")
    LiveData<SuitedForVO> getSuitedForByIdLD(String suitedForId);

}
