package wartee.tunlinaung.xyz.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "meal_shop")
public class MealShopVO {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "meal_shop_id")
    private String mealShopId;

    public String getMealShopId() {
        return mealShopId;
    }

    public void setMealShopId(String mealShopId) {
        this.mealShopId = mealShopId;
    }
}
