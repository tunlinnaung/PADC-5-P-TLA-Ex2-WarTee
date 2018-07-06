package wartee.tunlinaung.xyz.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wartee.tunlinaung.xyz.R;
import wartee.tunlinaung.xyz.data.vo.FoodVO;
import wartee.tunlinaung.xyz.data.vo.RestaurantVO;
import wartee.tunlinaung.xyz.delegates.OfferDelegates;

public class RestaurantsOffersViewHolder extends BaseViewHolder<RestaurantVO> {

    @BindView(R.id.tv_offer_title)
    TextView tvOfferTitle;

    private OfferDelegates mDelegates;

    private RestaurantVO mRestaurant;

    public RestaurantsOffersViewHolder(View itemView, OfferDelegates delegates) {
        super(itemView);
        this.mDelegates = delegates;
    }

    @Override
    public void setData(RestaurantVO data, int position) {
        this.mRestaurant = data;

        if (position == 0) {
            tvOfferTitle.setVisibility(View.VISIBLE);
        } else {
            tvOfferTitle.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View view) {
        mDelegates.onTapOffer(mRestaurant.getShopId());
    }
}
