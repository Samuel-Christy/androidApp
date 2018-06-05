package fr.free.samuelchristy.myzoo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

public class ZooMapActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(new ZooMapActivityView(this)); //lance la vue
        Log.i("onCreate: ", "killRoy was here !");
    }

    public class ZooMapActivityView extends View{

        Bitmap laCarte;

        public ZooMapActivityView(Context context) {
            super(context);
            laCarte = BitmapFactory.decodeResource(getResources(),R.drawable.zoo); //charge l'image
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(laCarte,0,0,null); //affiche l'image

        }
    }

}
