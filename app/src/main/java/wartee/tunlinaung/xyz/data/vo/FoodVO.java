package wartee.tunlinaung.xyz.data.vo;

import java.util.List;

public class FoodVO {


    /**
     * warDeeId : WD001
     * name : လက်ဖက်ရည်
     * images : ["http://cdn2.stylecraze.com/wp-content/uploads/2015/04/marjuana-tea.jpg","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT09AVRbvAxAJzZND2A19o4RQ5D3V3tpp-4KvsersqlpfscF1cLWA","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLmxpvxHxUiTPOGLq0qlFmukD3lE4xa2ziWnLKcwsK6WKGhRiM"]
     * generalTaste : [{"tasteId":"T001","taste":"ပုံမှန် ကျဆိမ့် ချိုဆိမ့်","tasteDesc":"မနက်စာအဖြစ် သောက်လေ့ရှိသောအရည်တမျိုး  အီကြာကွေးနှင့် တွဲစားခြင်းသည် အလိုက်ဖက်ဆုံးဖြစ်သည်"}]
     * suitedFor : [{"suitedForId":"SF001","suitedFor":"အဆာပြေသောက်ရန်သင့်တော်","suitedForDesc":"abc"}]
     * priceRangeMin : 2000
     * priceRangeMax : 3000
     * matchWarDeeList : [{"warDeeId":"WD002"},{"warDeeId":"WD003"},{"warDeeId":"WD004"}]
     * shopByDistance : [{"shopByDistanceId":"SBD001","mealShop":{"mealShopId":"MS016"},"distanceInFeet":123.45},{"shopByDistanceId":"SBD002","mealShop":{"mealShopId":"MS010"},"distanceInFeet":234.56}]
     * shopByPopularity : [{"shopByPopularityId":"SBP001","mealShop":{"mealShopId":"MS015"}},{"shopByPopularityId":"SBP002","mealShop":{"mealShopId":"MS016"}}]
     */

    private String warDeeId;
    private String name;
    private int priceRangeMin;
    private int priceRangeMax;
    private List<String> images;
    private List<GeneralTasteVO> generalTaste;
    private List<SuitedForVO> suitedFor;
    private List<MatchWarDeeListVO> matchWarDeeList;
    private List<ShopByDistanceVO> shopByDistance;
    private List<ShopByPopularityVO> shopByPopularity;

    public String getWarDeeId() {
        return warDeeId;
    }

    public void setWarDeeId(String warDeeId) {
        this.warDeeId = warDeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriceRangeMin() {
        return priceRangeMin;
    }

    public void setPriceRangeMin(int priceRangeMin) {
        this.priceRangeMin = priceRangeMin;
    }

    public int getPriceRangeMax() {
        return priceRangeMax;
    }

    public void setPriceRangeMax(int priceRangeMax) {
        this.priceRangeMax = priceRangeMax;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<GeneralTasteVO> getGeneralTaste() {
        return generalTaste;
    }

    public void setGeneralTaste(List<GeneralTasteVO> generalTaste) {
        this.generalTaste = generalTaste;
    }

    public List<SuitedForVO> getSuitedFor() {
        return suitedFor;
    }

    public void setSuitedFor(List<SuitedForVO> suitedFor) {
        this.suitedFor = suitedFor;
    }

    public List<MatchWarDeeListVO> getMatchWarDeeList() {
        return matchWarDeeList;
    }

    public void setMatchWarDeeList(List<MatchWarDeeListVO> matchWarDeeList) {
        this.matchWarDeeList = matchWarDeeList;
    }

    public List<ShopByDistanceVO> getShopByDistance() {
        return shopByDistance;
    }

    public void setShopByDistance(List<ShopByDistanceVO> shopByDistance) {
        this.shopByDistance = shopByDistance;
    }

    public List<ShopByPopularityVO> getShopByPopularity() {
        return shopByPopularity;
    }

    public void setShopByPopularity(List<ShopByPopularityVO> shopByPopularity) {
        this.shopByPopularity = shopByPopularity;
    }
}
