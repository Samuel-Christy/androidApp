package fr.free.samuelchristy.myzoo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AccueilActivity extends Activity {

    public static final String MY_APP_PREFERENCES = "zoo", MY_APP_PREFERENCES_KEY_ALERT = "alert";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);
        TextView v = findViewById(R.id.accueil_textView_news);
        v.setText("pouet pouet !");


        final Button button = findViewById(R.id.accueil_button_map);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ZooMapActivity.class);
                //v.getContext() = AccueilActivity.this
                startActivity(i);
            }
        });

        final Button buttonAlertActivity = findViewById(R.id.accueil_button_alertActivity);
        buttonAlertActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), AlertActivity.class);
                //v.getContext() = AccueilActivity.this
                startActivity(i);
            }
        });

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
}
