package wartee.tunlinaung.xyz.data.vo;

class ShopByPopularityVO {
    /**
     * shopByPopularityId : SBP001
     * mealShop : {"mealShopId":"MS015"}
     */

    private String shopByPopularityId;
    private MealShopVO mealShop;

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
}
