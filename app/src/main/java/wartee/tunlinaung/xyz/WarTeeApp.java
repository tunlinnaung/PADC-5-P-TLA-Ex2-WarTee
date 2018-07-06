package wartee.tunlinaung.xyz;

import android.app.Application;

import wartee.tunlinaung.xyz.data.models.WarTeeModel;

public class WarTeeApp extends Application {

    public static final String APP_LOG = WarTeeApp.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        WarTeeModel.initModel(getApplicationContext());
    }

}
