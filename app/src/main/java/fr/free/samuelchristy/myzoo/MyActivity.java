package fr.free.samuelchristy.myzoo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public abstract class MyActivity extends Activity {

    public static final String
            MY_APP_PREFERENCES = "zoo",
            MY_APP_PREFERENCES_KEY_ALERT = "alert",
            MESSAGE_KEY = "msg";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.accueil, menu);//dump notre menu dans l'activité


        SharedPreferences prefs = getSharedPreferences(MY_APP_PREFERENCES, Activity.MODE_PRIVATE);
        menu.findItem(R.id.menuOptionSubMenuAlertsButton).setChecked(prefs.getBoolean(MY_APP_PREFERENCES_KEY_ALERT, false));

        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuHomeButton:
                startActivity(new Intent(this, ZooMapActivity.class));
                return true;
            case R.id.menuOptionSubMenuAlertsButton: {
                item.setChecked(!item.isChecked());

                SharedPreferences prefs = getSharedPreferences(MY_APP_PREFERENCES, Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(MY_APP_PREFERENCES_KEY_ALERT, item.isChecked());
                editor.commit();
                return true;
            }


            default:
                return super.onMenuItemSelected(featureId, item);
        }
    }

    protected void toast(String message) {
        if (getSharedPreferences(MY_APP_PREFERENCES, Activity.MODE_PRIVATE)
                .getBoolean(MY_APP_PREFERENCES_KEY_ALERT, false)) {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }


}
