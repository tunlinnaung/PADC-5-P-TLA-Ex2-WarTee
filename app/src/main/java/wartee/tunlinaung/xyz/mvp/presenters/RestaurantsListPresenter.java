package wartee.tunlinaung.xyz.mvp.presenters;

import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import wartee.tunlinaung.xyz.data.models.WarTeeModel;
import wartee.tunlinaung.xyz.data.vo.FoodVO;
import wartee.tunlinaung.xyz.data.vo.RestaurantVO;
import wartee.tunlinaung.xyz.delegates.CategoryDelegates;
import wartee.tunlinaung.xyz.delegates.OfferDelegates;
import wartee.tunlinaung.xyz.mvp.views.RestaurantListView;

public class RestaurantsListPresenter extends BasePresenter<RestaurantListView>
                                      implements CategoryDelegates, OfferDelegates {

    private MutableLiveData<List<RestaurantVO>> mRestaurantListLD;
    private MutableLiveData<List<FoodVO>> mFoodListLD;

    @Override
    public void initPresenter(RestaurantListView mView) {
        super.initPresenter(mView);
        mRestaurantListLD = new MutableLiveData<>();
        mFoodListLD = new MutableLiveData<>();

        WarTeeModel.getInstance().startLoadingDatas(mRestaurantListLD, mFoodListLD, mErrorLD);
    }

    public MutableLiveData<List<RestaurantVO>> getmRestaurantListLD() {
        return mRestaurantListLD;
    }

    public MutableLiveData<List<FoodVO>> getmFoodListLD() {
        return mFoodListLD;
    }

    @Override
    public void onTapCategory(String categoryId) {
        mView.launchRestaurantDetails(categoryId);
    }

    @Override
    public void onTapOffer(String offerId) {
        mView.launchFoodDetailsScreen(offerId);
    }

}
