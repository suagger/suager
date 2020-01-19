package com.example.cattonview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button scaleBtn;
    Button rotateBtn;
    Animation rotateAnimation;
    Button translateBtn;
    Animation translateAnimation;
    Animation setAnimation;
    Button setBtn;
    Button alphaBtn;
    Animation alphaAnimation;
    Animation scaleAnimation;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //从XML中获取动画
        scaleAnimation = AnimationUtils.loadAnimation(this,R.anim.scalanim);
        rotateAnimation = AnimationUtils.loadAnimation(this,R.anim.rotateanim);
        translateAnimation = AnimationUtils.loadAnimation(this,R.anim.translateanim);
        alphaAnimation = AnimationUtils.loadAnimation(this,R.anim.alphaanim);
        setAnimation = AnimationUtils.loadAnimation(this,R.anim.setanim);

        scaleBtn = findViewById(R.id.btn_animation);
        setBtn = findViewById(R.id.set_animation);
        translateBtn = findViewById(R.id.translate_animation);
        rotateBtn = findViewById(R.id.rotate_animation);
        alphaBtn = findViewById(R.id.alpha_animation);
        tv = findViewById(R.id.tv);


        scaleBtn.setOnClickListener(this);
        translateBtn.setOnClickListener(this);
        rotateBtn.setOnClickListener(this);
        alphaBtn.setOnClickListener(this);
        setBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.rotate_animation:
                tv.startAnimation(rotateAnimation);
                break;
            case R.id.alpha_animation:
                tv.startAnimation(alphaAnimation);
                break;
            case R.id.btn_animation:
                tv.startAnimation(scaleAnimation);
                break;
            case R.id.translate_animation:
                tv.startAnimation(translateAnimation);
                break;
            case R.id.set_animation:
                tv.startAnimation(setAnimation);
                break;
                default:
        }
    }
}
