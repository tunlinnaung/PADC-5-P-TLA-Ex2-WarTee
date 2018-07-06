package wartee.tunlinaung.xyz.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import wartee.tunlinaung.xyz.R;
import wartee.tunlinaung.xyz.data.vo.FoodVO;
import wartee.tunlinaung.xyz.data.vo.RestaurantVO;
import wartee.tunlinaung.xyz.delegates.CategoryDelegates;

public class RestaurantsCategoriesViewHolder extends BaseViewHolder<FoodVO> {

    private CategoryDelegates mDelegates;
    private FoodVO mFood;

    public RestaurantsCategoriesViewHolder(View itemView, CategoryDelegates delegates) {
        super(itemView);
        this.mDelegates = delegates;
    }

    @Override
    public void setData(FoodVO data, int position) {
        this.mFood = data;
    }

    @Override
    public void onClick(View view) {
        mDelegates.onTapCategory(mFood.getWarDeeId());
    }
}
