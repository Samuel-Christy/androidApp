package fr.free.samuelchristy.myzoo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class AquariumActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(new AquariumMapActivityView(this)); //lance la vue
        Log.i("onCreate: ", "killRoy was here !");
//        Toast.makeText(this, "kapoué 2!", Toast.LENGTH_SHORT).show();
        Log.d("aquarium","oncreate");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getActionMasked()==MotionEvent.ACTION_DOWN) {

            Log.d("aquarium", "touch");
            Intent i = new Intent(this, PopCornActivity.class);
            i.putExtra(PopCornActivity.MESSAGE_KEY,"pas de popcorn aux poissons !");
            startActivity(i);
        }
        return true;
    }



    public class AquariumMapActivityView extends View{

        Bitmap laCarte,lacarte2;


        public AquariumMapActivityView(Context context) {
            super(context);
            Log.d("aquarium","view constructor");
            laCarte = BitmapFactory.decodeResource(getResources(),R.drawable.aquarium); //charge l'image


        }

        @Override
        protected void onDraw(Canvas canvas) {
            Log.d("aquarium","onDraw");

            canvas.drawBitmap(laCarte,0,0,null); //affiche l'image


        }
    }

}
