package fr.free.samuelchristy.myzoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AccueilActivity extends MyActivity {



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

                startActivity(i);
            }
        });

        final Button buttonAlertActivity = findViewById(R.id.accueil_button_alertActivity);
        buttonAlertActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), AlertActivity.class);

                startActivity(i);
            }
        });

    }


}
