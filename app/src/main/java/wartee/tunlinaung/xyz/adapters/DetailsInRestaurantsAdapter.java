package wartee.tunlinaung.xyz.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import wartee.tunlinaung.xyz.R;
import wartee.tunlinaung.xyz.data.vo.RestaurantVO;
import wartee.tunlinaung.xyz.viewitems.DetailsInRestaurantsViewItem;

public class DetailsInRestaurantsAdapter extends PagerAdapter {

    private List<RestaurantVO> mRestaurants;

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Context context = container.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        DetailsInRestaurantsViewItem view =
                (DetailsInRestaurantsViewItem) layoutInflater.inflate(R.layout.item_restaurants_details,
                        container, false);

        // bind data to viewpager's view item
        //view.setFood(mRestaurants.get(position));

        // manually put view to viewGroup (only for ViewPager)
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public void setRestaurants(List<RestaurantVO> restaurants) {
        this.mRestaurants = restaurants;
        notifyDataSetChanged();
    }

}
