package wartee.tunlinaung.xyz.data.models;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import wartee.tunlinaung.xyz.data.vo.FoodVO;
import wartee.tunlinaung.xyz.data.vo.RestaurantVO;
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

    public static WarTeeModel newInstance() {
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
                            }
                            if (mRestaurantList.size() > 0) {
                                restaurantListLD.setValue(mRestaurantList);
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


}
