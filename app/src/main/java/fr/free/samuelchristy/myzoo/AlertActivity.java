package fr.free.samuelchristy.myzoo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class AlertActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert);


    }

    public void btnonClick(View v) {
        String s = ((TextView) findViewById(R.id.alert_titre_edit)).getText().toString();
        s += ", ";
        s += ((TextView) findViewById(R.id.alerte_lieur_edit)).getText().toString();
        s += ", ";
        s += ((TextView) findViewById(R.id.alerte_description_edit)).getText().toString();
        s += ", ";
        s += ((CheckBox) findViewById(R.id.alerte_urgent_cb)).isChecked() ? "urgent" : "pas urgent";

        Toast.makeText(v.getContext(), s, Toast.LENGTH_SHORT).show();

    }
}
