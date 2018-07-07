package wartee.tunlinaung.xyz.data.models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import wartee.tunlinaung.xyz.WarTeeApp;
import wartee.tunlinaung.xyz.data.vo.FoodVO;
import wartee.tunlinaung.xyz.data.vo.GeneralTasteVO;
import wartee.tunlinaung.xyz.data.vo.MatchWarDeeListVO;
import wartee.tunlinaung.xyz.data.vo.MealShopVO;
import wartee.tunlinaung.xyz.data.vo.RestaurantVO;
import wartee.tunlinaung.xyz.data.vo.ReviewsVO;
import wartee.tunlinaung.xyz.data.vo.ShopByDistanceVO;
import wartee.tunlinaung.xyz.data.vo.ShopByPopularityVO;
import wartee.tunlinaung.xyz.data.vo.SuitedForVO;
import wartee.tunlinaung.xyz.utils.AppConstants;

public class WarTeeModel extends BaseModel {

    private static WarTeeModel sObjInstance;

    private List<RestaurantVO> mRestaurantList = new ArrayList<>();
    private List<FoodVO> mFoodList = new ArrayList<>();
    private String mRestaurantErrorMsg;
    private String mFoodErrorMsg;

    private WarTeeModel(Context context) {
        super(context);
    }

    public static void initModel(Context context) {
        sObjInstance = new WarTeeModel(context);
    }

    public static WarTeeModel getInstance() {
        if (sObjInstance == null) {
            throw new RuntimeException("WarTeeModel is being invoked before initializing.");
        }
        return sObjInstance;
    }

    public void startLoadingDatas(MutableLiveData<List<RestaurantVO>> restaurantListLD,
                                  MutableLiveData<List<FoodVO>> foodListLD,
                                  MutableLiveData<String> errorMsgLD) {

        mTheApi.getRestaurants(AppConstants.ACCESS_TOKEN)
                .flatMap(restaurantResponse -> {
                    if (restaurantResponse != null
                            && restaurantResponse.getAstlMealShop() != null
                            && restaurantResponse.getAstlMealShop().size() > 0) {
                        mRestaurantList.addAll(restaurantResponse.getAstlMealShop());
                    } else {
                        mRestaurantErrorMsg = "Empty restaurants";
                    }

                    return mTheApi.getFoods(AppConstants.ACCESS_TOKEN);
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        foodResponse -> {
                            if (foodResponse != null
                                    && foodResponse.getAstlWarDee() != null
                                    && foodResponse.getAstlWarDee().size() > 0) {
                                mFoodList.addAll(foodResponse.getAstlWarDee());
                            } else {
                                mFoodErrorMsg = "Empty Foods";
                            }

                            if (mFoodList.size() > 0) {
                                foodListLD.setValue(mFoodList);
                                persisteFoodList(mFoodList);
                            }
                            if (mRestaurantList.size() > 0) {
                                restaurantListLD.setValue(mRestaurantList);
                                persistResturantList(mRestaurantList);
                            }
                            if (mRestaurantErrorMsg != null) {
                                errorMsgLD.setValue(mRestaurantErrorMsg);
                            }
                            if (mFoodErrorMsg != null) {
                                errorMsgLD.setValue(mFoodErrorMsg);
                            }
                        },
                        throwable -> {
                            errorMsgLD.setValue(throwable.getMessage());
                        }
                );

    }

    private void persisteFoodList(List<FoodVO> foodList) {
        List<GeneralTasteVO> generalTasteList = new ArrayList<>();
        List<SuitedForVO> suitedForList = new ArrayList<>();
        List<MatchWarDeeListVO> matchWarDeeList = new ArrayList<>();
        List<MealShopVO> mealShopList = new ArrayList<>();
        List<ShopByDistanceVO> shopByDistanceList = new ArrayList<>();
        List<ShopByPopularityVO> shopByPopularityList = new ArrayList<>();

        for (FoodVO food : foodList) {
            for (GeneralTasteVO generalTaste : food.getGeneralTaste()) {
                generalTaste.setFoodId(food.getWarDeeId());
                generalTasteList.add(generalTaste);
            }
            for (SuitedForVO suitedFor : food.getSuitedFor()) {
                suitedFor.setFoodId(food.getWarDeeId());
                suitedForList.add(suitedFor);
            }
            for (MatchWarDeeListVO matchWarDee : food.getMatchWarDeeList()) {
                matchWarDee.setFoodId(food.getWarDeeId());
                matchWarDeeList.add(matchWarDee);
            }
            for (ShopByDistanceVO shopByDistance : food.getShopByDistance()) {
                mealShopList.add(shopByDistance.getMealShop());

                shopByDistance.setFoodId(food.getWarDeeId());
                shopByDistanceList.add(shopByDistance);
            }
            for (ShopByPopularityVO shopByPopularity : food.getShopByPopularity()) {
                mealShopList.add(shopByPopularity.getMealShop());

                shopByPopularity.setFoodId(food.getWarDeeId());
                shopByPopularityList.add(shopByPopularity);
            }
        }

        long[] insertedGeneratedTaste = mTheDB.generalTasteDao().insertGeneralTaste(generalTasteList.toArray(new GeneralTasteVO[0]));
        Log.d(WarTeeApp.LOG_TAG, "insertedGeneratedTaste : " + insertedGeneratedTaste);

        long[] insertedSuitedFor = mTheDB.suitedForDao().insertSuitedFor(suitedForList.toArray(new SuitedForVO[0]));
        Log.d(WarTeeApp.LOG_TAG, "insertedSuitedFor : " + insertedSuitedFor);

        long[] insertedMatchWarDee = mTheDB.matchWarDeeListDao().insertMatchWarDee(matchWarDeeList.toArray(new MatchWarDeeListVO[0]));
        Log.d(WarTeeApp.LOG_TAG, "insertedMatchWarDee : " + insertedMatchWarDee);

        long[] insertedShopByDistance = mTheDB.shopByDistanceDao().insertShopByDistance(shopByDistanceList.toArray(new ShopByDistanceVO[0]));
        Log.d(WarTeeApp.LOG_TAG, "insertedShopByDistance : " + insertedShopByDistance);

        long[] insertedShopByPopularity = mTheDB.shopByPopularityDao().insertShopByPopularity(shopByPopularityList.toArray(new ShopByPopularityVO[0]));
        Log.d(WarTeeApp.LOG_TAG, "insertedShopByPopularity : " + insertedShopByPopularity);

        long[] insertedMealShop = mTheDB.mealShopDao().insertMealShop(mealShopList.toArray(new MealShopVO[0]));
        Log.d(WarTeeApp.LOG_TAG, "insertedMealShop : " + insertedMealShop);

        long[] insertedFoods = mTheDB.foodDao().insertFood(foodList.toArray(new FoodVO[0]));
        Log.d(WarTeeApp.LOG_TAG, "insertedFoods : " + insertedFoods);
    }

    private void persistResturantList(List<RestaurantVO> restaurantList) {
        List<ReviewsVO> reviewsList = new ArrayList<>();

        for (RestaurantVO restaurant : restaurantList) {
            for (ReviewsVO reviews : restaurant.getReviews()) {
                reviews.setRestaurantId(restaurant.getShopId());
            }
        }

        long[] insertedReviews = mTheDB.reviewsDao().insertReview(reviewsList.toArray(new ReviewsVO[0]));
        Log.d(WarTeeApp.LOG_TAG, "insertedReviews : " + insertedReviews);

        long[] insertedRestaurants = mTheDB.restaurantDao().insertRestaurant(restaurantList.toArray(new RestaurantVO[0]));
        Log.d(WarTeeApp.LOG_TAG, "insertedRestaurants : " + insertedRestaurants);

    }

    public LiveData<FoodVO> getFoodByIdLD(final String foodId) {
        final MutableLiveData<FoodVO> foodLD = new MutableLiveData<>();
        mTheDB.foodDao().getFoodsByIdLD(foodId).observeForever(food -> {
            if (food != null) {
                for (ShopByDistanceVO shopByDistance : food.getShopByDistance()) {
                    //TODO
                    shopByDistance.setMealShop(mTheDB.mealShopDao().getMatchMealShopById(shopByDistance.getMealShopId()));
                }
                for (ShopByPopularityVO shopByPopularity : food.getShopByPopularity()) {
                    //TODO
                    shopByPopularity.setMealShop(mTheDB.mealShopDao().getMatchMealShopById(shopByPopularity.getMealShopId()));
                }

                foodLD.setValue(food);
            }
        });
        return foodLD;
    }

    public LiveData<RestaurantVO> getRestaurantByIdLD(final String restaurantId) {
        final MutableLiveData<RestaurantVO> restaurantLD = new MutableLiveData<>();
        mTheDB.restaurantDao().getRestaurantsByIdLD(restaurantId).observeForever(restaurant -> restaurantLD.setValue(restaurant));
        return restaurantLD;
    }


}
