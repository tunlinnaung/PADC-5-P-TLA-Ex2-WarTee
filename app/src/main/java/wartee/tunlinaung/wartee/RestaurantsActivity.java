package wartee.tunlinaung.wartee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class RestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

}
