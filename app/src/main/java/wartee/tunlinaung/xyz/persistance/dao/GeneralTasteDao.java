package wartee.tunlinaung.xyz.persistance.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import wartee.tunlinaung.xyz.data.vo.FoodVO;
import wartee.tunlinaung.xyz.data.vo.GeneralTasteVO;

@Dao
public interface GeneralTasteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertGeneralTaste(GeneralTasteVO... generalTasteVOs);

    @Query("SELECT * FROM general_taste")
    List<GeneralTasteVO> getAllGeneralTastes();

    @Query("SELECT * FROM general_taste WHERE taste_id= :tasteId")
    GeneralTasteVO getGeneralTastesByFoodId(String tasteId);

    @Query("SELECT * FROM general_taste WHERE taste_id= :tasteId")
    LiveData<GeneralTasteVO> getGeneralTastesByIdLD(String tasteId);

}
