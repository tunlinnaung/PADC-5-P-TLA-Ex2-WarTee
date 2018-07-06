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
import wartee.tunlinaung.xyz.delegates.CategoryDelegates;
import wartee.tunlinaung.xyz.viewholders.RestaurantsCategoriesViewHolder;

public class RestaurantsCategoriesAdapter extends BaseRecyclerAdapter<RestaurantsCategoriesViewHolder, FoodVO> {

    private CategoryDelegates mDelegates;

    public RestaurantsCategoriesAdapter(Context context, CategoryDelegates delegates) {
        super(context);
        this.mDelegates = delegates;
    }

    @NonNull
    @Override
    public RestaurantsCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View newsItemView = mLayoutInflator.inflate(R.layout.item_restaurants_category, parent, false);
        return new RestaurantsCategoriesViewHolder(newsItemView, mDelegates);
    }

}
