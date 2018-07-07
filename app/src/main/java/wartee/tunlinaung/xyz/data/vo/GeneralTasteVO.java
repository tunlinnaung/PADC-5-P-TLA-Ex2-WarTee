package wartee.tunlinaung.xyz.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "general_taste")
public class GeneralTasteVO {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "taste_id")
    private String tasteId;
    private String taste;
    @ColumnInfo(name = "taste_desc")
    private String tasteDesc;
    @ColumnInfo(name = "food_id")
    private transient String foodId;

    public String getTasteId() {
        return tasteId;
    }

    public void setTasteId(String tasteId) {
        this.tasteId = tasteId;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getTasteDesc() {
        return tasteDesc;
    }

    public void setTasteDesc(String tasteDesc) {
        this.tasteDesc = tasteDesc;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }
}
