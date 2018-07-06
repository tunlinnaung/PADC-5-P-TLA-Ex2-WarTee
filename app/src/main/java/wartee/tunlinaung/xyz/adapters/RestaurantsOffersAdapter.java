package wartee.tunlinaung.xyz.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import wartee.tunlinaung.xyz.R;
import wartee.tunlinaung.xyz.data.vo.FoodVO;
import wartee.tunlinaung.xyz.data.vo.RestaurantVO;
import wartee.tunlinaung.xyz.delegates.OfferDelegates;
import wartee.tunlinaung.xyz.viewholders.RestaurantsCategoriesViewHolder;
import wartee.tunlinaung.xyz.viewholders.RestaurantsOffersViewHolder;

public class RestaurantsOffersAdapter extends BaseRecyclerAdapter<RestaurantsOffersViewHolder, RestaurantVO> {

    private OfferDelegates mDelegates;

    public RestaurantsOffersAdapter(Context context, OfferDelegates delegates) {
        super(context);
        this.mDelegates = delegates;
    }

    @NonNull
    @Override
    public RestaurantsOffersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // layout id, binding parent, attach to parent
        View offersItemView = mLayoutInflator.inflate(R.layout.item_restaurants_offer, parent, false);
        return new RestaurantsOffersViewHolder(offersItemView, mDelegates);
    }

}
