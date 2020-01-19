package com.example.interpolatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private Button btn;
    private Button cancel;
    private ValueAnimator repeatAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                doAnimation();
                repeatAnimator = doRepeatAnim();
            }
        });

        cancel = findViewById(R.id.btn_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                repeatAnimator.cancel();
                repeatAnimator.removeAllUpdateListeners();
                repeatAnimator.removeAllListeners();
            }
        });



        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"clicked me",Toast.LENGTH_LONG).show();
            }
        });

    }

    private void doAnimation(){
//        ValueAnimator animator = ValueAnimator.ofInt(0,400);
//        animator.setDuration(1000);

        ValueAnimator animator = ValueAnimator.ofFloat(0f,400f,50f,300f);
        animator.setDuration(3000);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
//                int curValue = (int) animation.getAnimatedValue();
                float curValueFloat = (float) animation.getAnimatedValue();
                int curValue = (int) curValueFloat;
                tv.layout(curValue,curValue,curValue + tv.getWidth(),curValue + tv.getHeight());
            }
        });
        animator.start();
    }

    private ValueAnimator doRepeatAnim(){
        ValueAnimator anim = ValueAnimator.ofInt(0,400);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();
                tv.layout(tv.getLeft(), curValue, tv.getRight(), tv.getHeight() + curValue);
            }
        });

        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d("hello","animation start");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("hello","animation end");

            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.d("hello","animation cancel");

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d("hello","animation repeat");

            }
        });
        anim.setRepeatCount(ValueAnimator.INFINITE);
        anim.setRepeatMode(ValueAnimator.REVERSE);
        anim.setDuration(1000);
        anim.start();
        return anim;
    }
}
