package wartee.tunlinaung.xyz.mvp.presenters;

import android.arch.lifecycle.LiveData;

import wartee.tunlinaung.xyz.data.models.WarTeeModel;
import wartee.tunlinaung.xyz.data.vo.FoodVO;
import wartee.tunlinaung.xyz.data.vo.RestaurantVO;
import wartee.tunlinaung.xyz.mvp.views.RestaurantDetailsView;

public class RestaurantDetailsPresenter extends BasePresenter<RestaurantDetailsView> {

    @Override
    public void initPresenter(RestaurantDetailsView mView) {
        super.initPresenter(mView);
    }

    public LiveData<RestaurantVO> onUiReadyForRestaurant(String restaurantId) {
        return WarTeeModel.getInstance().getRestaurantByIdLD(restaurantId);
    }

    public LiveData<FoodVO> onUiReadyForFood(String foodId) {
        return WarTeeModel.getInstance().getFoodByIdLD(foodId);
    }
}
