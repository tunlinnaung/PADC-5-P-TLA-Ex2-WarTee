package wartee.tunlinaung.xyz.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import butterknife.ButterKnife;
import butterknife.OnClick;
import wartee.tunlinaung.xyz.R;

public class RestaurantsDetailsActivity extends AppCompatActivity {

    private static final String IE_OFFER_ID = "IE_OFFER_ID";
    private static final String IE_TYPE = "IE_TYPE";

    public static Intent newIntent(Context context, String offerId, String type) {
        Intent intent = new Intent(context, RestaurantsDetailsActivity.class);
        intent.putExtra(IE_OFFER_ID, offerId);
        intent.putExtra(IE_TYPE, type);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants_details);

        ButterKnife.bind(this, this);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @OnClick(R.id.iv_close)
    public void onTapClose(View view) {
        super.onBackPressed();
        finish();
    }

}
