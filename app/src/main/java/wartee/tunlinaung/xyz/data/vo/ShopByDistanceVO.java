package wartee.tunlinaung.xyz.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "shop_by_distance")
public class ShopByDistanceVO {
    /**
     * shopByDistanceId : SBD001
     * mealShop : {"mealShopId":"MS016"}
     * distanceInFeet : 123.45
     */

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "shop_by_distance_id")
    private String shopByDistanceId;

    @Ignore
    private MealShopVO mealShop;

    @ColumnInfo(name = "meal_shop_id")
    private String mealShopId;

    @ColumnInfo(name = "distance_in_feet")
    private double distanceInFeet;

    @ColumnInfo(name = "foodId")
    private transient String foodId;

    public String getShopByDistanceId() {
        return shopByDistanceId;
    }

    public void setShopByDistanceId(String shopByDistanceId) {
        this.shopByDistanceId = shopByDistanceId;
    }

    public MealShopVO getMealShop() {
        return mealShop;
    }

    public void setMealShop(MealShopVO mealShop) {
        this.mealShop = mealShop;
    }

    public double getDistanceInFeet() {
        return distanceInFeet;
    }

    public void setDistanceInFeet(double distanceInFeet) {
        this.distanceInFeet = distanceInFeet;
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
