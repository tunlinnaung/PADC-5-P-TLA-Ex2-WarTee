package wartee.tunlinaung.xyz.viewitems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import wartee.tunlinaung.xyz.R;
import wartee.tunlinaung.xyz.data.vo.RestaurantVO;

public class DetailsInRestaurantsViewItem extends FrameLayout {

    @BindView(R.id.iv_restaurants_details_image)
    ImageView ivRestaurantsDetailsImage;

    @BindView(R.id.tv_restaurant_food_title)
    TextView tvRestaurantFoodTitle;

    @BindView(R.id.tv_restaurant_food_details)
    TextView tvRestaurantFoodDetails;

    public DetailsInRestaurantsViewItem(@NonNull Context context) {
        super(context);
    }

    public DetailsInRestaurantsViewItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DetailsInRestaurantsViewItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setData(RestaurantVO restaurant) {
        tvRestaurantFoodTitle.setText(restaurant.getName());
        tvRestaurantFoodDetails.setText(restaurant.getAddress());
        Glide.with(ivRestaurantsDetailsImage.getContext())
                .load(restaurant.getShopImages().get(0))
                .into(ivRestaurantsDetailsImage);
    }

}
