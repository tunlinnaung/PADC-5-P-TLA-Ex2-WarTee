package wartee.tunlinaung.xyz.data.vo;

class ShopByDistanceVO {
    /**
     * shopByDistanceId : SBD001
     * mealShop : {"mealShopId":"MS016"}
     * distanceInFeet : 123.45
     */

    private String shopByDistanceId;
    private MealShopVO mealShop;
    private double distanceInFeet;

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
}
