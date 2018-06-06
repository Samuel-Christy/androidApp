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
        i.putExtra(PopCornActivity.MESSAGE_KEY,"les piafs non plus ne mangent pas de popcorn"); //si objet, doit implementer / hériter interface Parcelable ou Bundle
        this.setResult(0,i);

        super.onBackPressed();
        // finish(); //-> idem que  super.onBackPressed();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getActionMasked()==MotionEvent.ACTION_DOWN) {

//            Log.d("aquarium", "touch");
            Intent i = new Intent(this, PopCornActivity.class);
            i.putExtra(PopCornActivity.MESSAGE_KEY,"pas de popcorn aux wazos !");
            startActivity(i);
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
