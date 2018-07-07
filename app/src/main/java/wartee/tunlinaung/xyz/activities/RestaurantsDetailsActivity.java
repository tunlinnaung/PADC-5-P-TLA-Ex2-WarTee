package wartee.tunlinaung.xyz.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;

import butterknife.ButterKnife;
import butterknife.OnClick;
import wartee.tunlinaung.xyz.R;
import wartee.tunlinaung.xyz.data.vo.FoodVO;
import wartee.tunlinaung.xyz.data.vo.RestaurantVO;
import wartee.tunlinaung.xyz.mvp.presenters.RestaurantDetailsPresenter;
import wartee.tunlinaung.xyz.mvp.views.RestaurantDetailsView;
import wartee.tunlinaung.xyz.utils.AppConstants;

public class RestaurantsDetailsActivity extends BaseActivity implements RestaurantDetailsView {

    private static final String IE_WAR_TEE_ID = "IE_WAR_TEE_ID";
    private static final String IE_TYPE = "IE_TYPE";

    private RestaurantDetailsPresenter mPresenter;

    public static Intent newIntent(Context context, String offerId, String type) {
        Intent intent = new Intent(context, RestaurantsDetailsActivity.class);
        intent.putExtra(IE_WAR_TEE_ID, offerId);
        intent.putExtra(IE_TYPE, type);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants_details);

        ButterKnife.bind(this, this);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mPresenter = ViewModelProviders.of(this).get(RestaurantDetailsPresenter.class);
        mPresenter.initPresenter(this);
        mPresenter.getErrorLD().observe(this, this);

        String type = getIntent().getStringExtra(IE_TYPE);
        if (type != null && type.equals(AppConstants.CATEGORY)) {
            String warDeeId = getIntent().getStringExtra(IE_WAR_TEE_ID);
            mPresenter.onUiReadyForFood(warDeeId).observe(this, food -> displayFoodDetails(food));
        } else if (type != null && type.equals(AppConstants.CATEGORY)) {
            String warDeeId = getIntent().getStringExtra(IE_WAR_TEE_ID);
            mPresenter.onUiReadyForRestaurant(warDeeId).observe(this, restaurant -> displayRestaurantDetails(restaurant));
        }
    }

    @OnClick(R.id.iv_close)
    public void onTapClose(View view) {
        super.onBackPressed();
        finish();
    }

    @Override
    public void displayErrorMsg(String errorMsg) {

    }

    private void displayFoodDetails(FoodVO food) {
        // TODO bind details
    }

    private void displayRestaurantDetails(RestaurantVO restaurant) {
        // TODO bind details
    }
}
