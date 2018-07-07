package wartee.tunlinaung.xyz;

import android.app.Application;

import wartee.tunlinaung.xyz.data.models.WarTeeModel;

public class WarTeeApp extends Application {

    public static final String LOG_TAG = WarTeeApp.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        WarTeeModel.initModel(getApplicationContext());
    }

}
