package fr.free.samuelchristy.myzoo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ZooHelper extends SQLiteOpenHelper {

    public ZooHelper(Context c) {
        super(c, "zoo.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String structure = "CREATE TABLE alertes(id INTEGER PRIMARY KEY, titre TEXT, lieu TEXT, description TEXT)";

        db.execSQL(structure);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void save(String titre, String lieu, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "INSERT INTO alertes(titre,lieu,description) VALUES(?,?,?)";

        db.execSQL(query, new Object[]{titre, lieu, description});


        db.close();


    }

    public void all() {

    }


}
