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

public class ZooMapActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(new ZooMapActivityView(this)); //lance la vue
        Log.i("zoo: ", "o,Create");

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //launch aquarium activity
        if(event.getActionMasked()==MotionEvent.ACTION_DOWN) {
//            Toast.makeText(this, "pouet !", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, AquariumActivity.class);
//            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            Log.d("zoo", "touch");
        }
        return true;
    }

    public class ZooMapActivityView extends View{

        Bitmap laCarte;

        public ZooMapActivityView(Context context) {
            super(context);
            laCarte = BitmapFactory.decodeResource(getResources(),R.drawable.zoo); //charge l'image
            Log.d("zoo", "view constructor");
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Log.d("zoo", "draw");
            canvas.drawBitmap(laCarte,0,0,null); //affiche l'image

        }
    }

}
