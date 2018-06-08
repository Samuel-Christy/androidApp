package fr.free.samuelchristy.myzoo;

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

import java.util.Random;

public class AquariumActivity extends MyActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        this.setContentView(new AquariumMapActivityView(this)); //lance la vue
        Log.i("onCreate: ", "killRoy was here !");
//        Toast.makeText(this, "kapoué 2!", Toast.LENGTH_SHORT).show();
        Log.d("aquarium","oncreate");
    }

    private String randomFish(){
        String[] fishes  = getResources().getStringArray(R.array.fishes);
        return fishes[new Random().nextInt(fishes.length)];
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getActionMasked()==MotionEvent.ACTION_DOWN) {
            Log.d("aquarium", "touch");
            Intent i = new Intent(this, PopCornActivity.class);
//            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.putExtra(PopCornActivity.MESSAGE_KEY,getString(R.string.toast_fish_popcorn_warning,randomFish()));
            startActivity(i);
        }
        return true;
    }



    public class AquariumMapActivityView extends View{

        Bitmap laCarte;


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
