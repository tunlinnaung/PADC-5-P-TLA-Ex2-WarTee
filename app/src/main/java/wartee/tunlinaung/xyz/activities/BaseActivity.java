package wartee.tunlinaung.xyz.activities;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import wartee.tunlinaung.xyz.mvp.views.BaseView;

/**
 * Created by aung on 12/2/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView, Observer<String> {

    @Override
    public void onChanged(@Nullable String errorMsg) {
        displayErrorMsg(errorMsg);
    }

    public void displayErrorMsg(String errorMsg) {

    }

}
