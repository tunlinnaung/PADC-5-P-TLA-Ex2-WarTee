package wartee.tunlinaung.wartee;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.arlib.floatingsearchview.FloatingSearchView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchRestaurantsActivity extends AppCompatActivity {

    @BindView(R.id.floating_search_view)
    FloatingSearchView mSearchView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_restaurants);
        ButterKnife.bind(this, this);

        mSearchView.setOnQueryChangeListener((oldQuery, newQuery) -> {

            //get suggestions based on newQuery

            //pass them on to the search view
            //mSearchView.swapSuggestions("");
        });

        mSearchView.setOnHomeActionClickListener(() -> { finish(); });
    }

}
