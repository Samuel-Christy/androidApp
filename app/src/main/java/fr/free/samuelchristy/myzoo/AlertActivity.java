package fr.free.samuelchristy.myzoo;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;

import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class AlertActivity extends MyActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert);


    }


    private void writeToFile(String data, String filename, Context context) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            try {
                File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                File file = new File(directory, filename);

                FileWriter writer = new FileWriter(file, true);
                writer.write(data);
                writer.close();

                Toast.makeText(this, data, Toast.LENGTH_LONG);
                finish();
            } catch (IOException e) {
                Log.e("Exception", "File write failed: ", e);
            }
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }
    }


    private void writeToDb(String titre, String lieu, String description) {
        try {
            ZooHelper hlpr = new ZooHelper(this);
            hlpr.save(titre, lieu, description);
        } catch (Exception e) {
            Log.e("envoyer", "erreur SQL", e);
        }
    }



    public void btnonClick(View v) {


        String titre = ((TextView) findViewById(R.id.alert_titre_edit)).getText().toString();
        String lieu = ((TextView) findViewById(R.id.alerte_lieur_edit)).getText().toString();
        String desc = ((TextView) findViewById(R.id.alerte_description_edit)).getText().toString();
        String urgent = ((CheckBox) findViewById(R.id.alerte_urgent_cb)).isChecked() ? "oui" : "non";

        writeToFile("\"" + titre + "\",\"" + lieu + "\",\"" + desc + "\",\"" + urgent + "\"\n", "alerts.csv", this);
        writeToDb(titre, lieu, desc);

//        Toast.makeText(v.getContext(), s, Toast.LENGTH_SHORT).show();


    }
}
