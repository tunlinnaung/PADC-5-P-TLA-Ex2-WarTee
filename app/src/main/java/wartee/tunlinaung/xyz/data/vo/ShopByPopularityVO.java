package wartee.tunlinaung.xyz.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "shop_by_popularity")
public class ShopByPopularityVO {
    /**
     * shopByPopularityId : SBP001
     * mealShop : {"mealShopId":"MS015"}
     */

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "shop_by_popularity_id")
    private String shopByPopularityId;

    @Ignore
    private MealShopVO mealShop;

    @ColumnInfo(name = "meal_shop_id")
    private String mealShopId;

    @ColumnInfo(name = "foodId")
    private transient String foodId;

    public String getShopByPopularityId() {
        return shopByPopularityId;
    }

    public void setShopByPopularityId(String shopByPopularityId) {
        this.shopByPopularityId = shopByPopularityId;
    }

    public MealShopVO getMealShop() {
        return mealShop;
    }

    public void setMealShop(MealShopVO mealShop) {
        this.mealShop = mealShop;
    }

    public String getMealShopId() {
        return mealShopId;
    }

    public void setMealShopId(String mealShopId) {
        this.mealShopId = mealShopId;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }
}
