package com.ninjageeks.sampledatetimeconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ninjageeks.datetimeconverter.DateTimeConverter;

import java.net.ConnectException;

public class MainActivity extends AppCompatActivity {

    private float xCoOrdinate, yCoOrdinate;
    float y;
    float x;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        context = this;
        ImageView btn = findViewById(R.id.btn);
        y = btn.getY();
        x = btn.getX();
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        xCoOrdinate = view.getX() - event.getRawX();
                        yCoOrdinate = view.getY() - event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float result = event.getRawX() + xCoOrdinate;
                        if (result < x){
                            view.animate().x(x).y(y).setDuration(0).start();
                        }else{
                            view.animate().x(event.getRawX() + xCoOrdinate).y(y).setDuration(0).start();
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        view.animate().x(x).y(y).setDuration(100).start();
                        break;
                }
                return true;
            }
        });
         DateTimeConverter.GetDateTimeNowOtherTimeZone(DateTimeConverter.GetTimeZone("GMT"),1,false).GetDateTime();
    }
}
