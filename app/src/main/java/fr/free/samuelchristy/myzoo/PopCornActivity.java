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

public class PopCornActivity extends MyActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(new PopCornActivityView(this)); //lance la vue
        Log.i("zoo: ", "onCreate");

        toast(getIntent().getStringExtra(MESSAGE_KEY));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {



        super.onActivityResult(requestCode, resultCode, data);

        toast(data.getStringExtra(MESSAGE_KEY));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //launch aquarium activity
        if(event.getActionMasked()==MotionEvent.ACTION_DOWN) {
//        Toast.makeText(this, "pouet !", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, VoliereActivity.class);

//        startActivity(i);
        startActivityForResult(i,0);
        Log.d("zoo", "touch");
        }
        return true;
    }


    public class PopCornActivityView extends View{

        Bitmap laCarte;

        public PopCornActivityView(Context context) {
            super(context);
            laCarte = BitmapFactory.decodeResource(getResources(),R.drawable.popcorn); //charge l'image
            Log.d("zoo", "view constructor");

        }

        @Override
        protected void onDraw(Canvas canvas) {
            Log.d("zoo", "draw");
            canvas.drawBitmap(laCarte,0,0,null); //affiche l'image

        }
    }

}
