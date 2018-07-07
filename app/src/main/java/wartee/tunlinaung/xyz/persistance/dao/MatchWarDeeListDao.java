package wartee.tunlinaung.xyz.persistance.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import wartee.tunlinaung.xyz.data.vo.FoodVO;
import wartee.tunlinaung.xyz.data.vo.GeneralTasteVO;
import wartee.tunlinaung.xyz.data.vo.MatchWarDeeListVO;

@Dao
public interface MatchWarDeeListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertMatchWarDee(MatchWarDeeListVO... matchWarDeeListVOs);

    @Query("SELECT * FROM match_war_dee")
    List<MatchWarDeeListVO> getAllMatchWarDeeList();

    @Query("SELECT * FROM match_war_dee WHERE war_dee_id= :warDeeId")
    MatchWarDeeListVO getMatchWarDeeListById(String warDeeId);

    @Query("SELECT * FROM match_war_dee WHERE war_dee_id= :warDeeId")
    LiveData<MatchWarDeeListVO> getMatchWarDeeListByIdLD(String warDeeId);

}
