package wartee.tunlinaung.xyz.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wartee.tunlinaung.xyz.R;
import wartee.tunlinaung.xyz.adapters.DetailsInRestaurantsAdapter;
import wartee.tunlinaung.xyz.adapters.RestaurantsCategoriesAdapter;
import wartee.tunlinaung.xyz.adapters.RestaurantsOffersAdapter;
import wartee.tunlinaung.xyz.components.EmptyViewPod;
import wartee.tunlinaung.xyz.components.SmartRecyclerView;
import wartee.tunlinaung.xyz.data.vo.FoodVO;
import wartee.tunlinaung.xyz.data.vo.RestaurantVO;
import wartee.tunlinaung.xyz.delegates.CategoryDelegates;
import wartee.tunlinaung.xyz.delegates.OfferDelegates;
import wartee.tunlinaung.xyz.mvp.presenters.RestaurantsListPresenter;
import wartee.tunlinaung.xyz.mvp.views.RestaurantListView;
import wartee.tunlinaung.xyz.utils.AppConstants;

public class RestaurantsActivity extends AppCompatActivity implements RestaurantListView {

    @BindView(R.id.vp_restaurants_details)
    ViewPager viewPager;

    @BindView(R.id.rv_restaurants_categories)
    SmartRecyclerView rvCategories;

    @BindView(R.id.rv_restaurants_offers)
    SmartRecyclerView rvOffers;

    @BindView(R.id.vp_empty_view_pod)
    EmptyViewPod vpEmptyViewPod;

    private DetailsInRestaurantsAdapter mDetailsInRestaurantsAdapter;
    private RestaurantsCategoriesAdapter mRestaurantsCategoriesAdapter;
    private RestaurantsOffersAdapter mRestaurantsOffersAdapter;

    private RestaurantsListPresenter mPresenter;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, RestaurantsActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        ButterKnife.bind(this, this);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mPresenter = ViewModelProviders.of(this).get(RestaurantsListPresenter.class);
        mPresenter.initPresenter(this);

        mDetailsInRestaurantsAdapter = new DetailsInRestaurantsAdapter();
        // TODO set restaurant to adapter
        viewPager.setAdapter(mDetailsInRestaurantsAdapter);

        rvCategories.setEmptyView(vpEmptyViewPod);
        mRestaurantsCategoriesAdapter = new RestaurantsCategoriesAdapter(getApplicationContext(), mPresenter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false);
        rvCategories.setLayoutManager(linearLayoutManager);
        rvCategories.setAdapter(mRestaurantsCategoriesAdapter);

        rvOffers.setEmptyView(vpEmptyViewPod);
        mRestaurantsOffersAdapter = new RestaurantsOffersAdapter(getApplicationContext(), mPresenter);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        rvOffers.setLayoutManager(linearLayoutManager);
        rvOffers.setAdapter(mRestaurantsOffersAdapter);

        mPresenter.getmFoodListLD().observe(this, this::displayCategoryList);
        mPresenter.getmRestaurantListLD().observe(this, this::displayOfferList);
    }

    @OnClick(R.id.ll_search_restaurant)
    public void onTapSearch(View view) {
        startActivity(SearchRestaurantsActivity.newIntent(getApplicationContext()));
    }

    @Override
    public void launchRestaurantDetails(String restaurantId) {
        startActivity(RestaurantsDetailsActivity.newIntent(getApplicationContext(), restaurantId, AppConstants.CATEGORY));
    }

    @Override
    public void launchFoodDetailsScreen(String foodId) {
        startActivity(RestaurantsDetailsActivity.newIntent(getApplicationContext(), foodId, AppConstants.OFFER));
    }

    @Override
    public void displayErrorMsg(String errorMsg) {
        Snackbar.make(rvCategories, errorMsg, Snackbar.LENGTH_INDEFINITE).show();
        Snackbar.make(rvOffers, errorMsg, Snackbar.LENGTH_INDEFINITE).show();
    }

    private void displayCategoryList(List<FoodVO> foodList) {
        mRestaurantsCategoriesAdapter.appendNewData(foodList);
    }

    private void displayOfferList(List<RestaurantVO> restaurantList) {
        mRestaurantsOffersAdapter.appendNewData(restaurantList);
    }
}
