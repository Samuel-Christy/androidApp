package fr.free.samuelchristy.myzoo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.time.Instant;

public class VoliereActivity extends Activity{



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(new VoliereActivityView(this)); //lance la vue
        Log.i("zoo: ", "onCreate");
        Toast.makeText(this,getIntent().getStringExtra(PopCornActivity.MESSAGE_KEY),Toast.LENGTH_LONG).show();

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent();
        i.putExtra(PopCornActivity.MESSAGE_KEY,getString(R.string.toast_birds_popcorn)); //si objet, doit implementer / hériter interface Parcelable ou Bundle
        this.setResult(0,i);

        super.onBackPressed();
        // finish(); //-> idem que  super.onBackPressed();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.d("touch x",""+event.getX());
        Log.d("touch y",""+event.getY());
        if(event.getActionMasked()==MotionEvent.ACTION_DOWN) {

            if(event.getX()<100 && event.getY()<200){
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(i);
            }
            else{
            Intent i = new Intent(this, PopCornActivity.class);
            i.putExtra(PopCornActivity.MESSAGE_KEY,getString( R.string.toast_birds_popcorn));
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            }
        }
        return true;
    }

    public class VoliereActivityView extends View{

        Bitmap laCarte;

        public VoliereActivityView(Context context) {
            super(context);
            laCarte = BitmapFactory.decodeResource(getResources(),R.drawable.chicken); //charge l'image
            Log.d("zoo", "view constructor");

        }

        @Override
        protected void onDraw(Canvas canvas) {
            Log.d("zoo", "draw");
            canvas.drawBitmap(laCarte,0,0,null); //affiche l'image

        }
    }

}
