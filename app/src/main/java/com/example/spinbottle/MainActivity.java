package com.example.spinbottle;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    
    private ImageView bot;
    private int lstDr;
    private Random rand = new Random();
    private boolean spn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bot = findViewById(R.id.bottle);
    }

    public void spinBottle(View v) {
        if (!spn) {
            int num = rand.nextInt(1800);

            float pX = bot.getWidth() / 2;
            float pY = bot.getHeight() / 2;

            Animation rot = new RotateAnimation(lstDr, num, pX, pY);

            rot.setDuration(2500);

            rot.setFillAfter(true);
            rot.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spn = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spn = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            lstDr = num;

            bot.startAnimation(rot);
        }
    }
}

// final commit