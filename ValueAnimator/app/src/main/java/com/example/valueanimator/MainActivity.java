package com.example.valueanimator;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button cancelAnim,btn;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cancelAnim = findViewById(R.id.cancel_anim);
        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAnimator();
            }
        });

    }

    private void doAnimator(){
//        ValueAnimator animator = ValueAnimator.ofInt(0,600);
        ValueAnimator animator = ValueAnimator.ofInt(0xffffff00,0xff0000ff);
        animator.setDuration(1000);

       /* animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();
                tv.layout(tv.getLeft(),curValue,tv.getRight(),tv.getHeight() + curValue);
            }
        });*/

       animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
           @Override
           public void onAnimationUpdate(ValueAnimator animation) {
               int curColor = (int) animation.getAnimatedValue();
               tv.setBackgroundColor(curColor);
           }
       });
//        animator.setInterpolator(new MyInterpolator());
//        animator.setEvaluator(new MyEvaluator());
//        animator.setEvaluator(new ReverseaEvaluator());
        //使用ArgbEvaluator进行颜色过渡
        animator.setEvaluator(new ArgbEvaluator());
        animator.start();
    }

}
//自定义插值器
class MyInterpolator implements TimeInterpolator{

    @Override
    public float getInterpolation(float input) {
        return 1 - input;
    }
}
//自定义Evaluator(正序)
class MyEvaluator implements TypeEvaluator<Integer>{

    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        return (int) (200 + fraction * (endValue - startValue));
    }
}
//自定义Evaluator(倒序)
class ReverseaEvaluator implements TypeEvaluator<Integer>{

    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        return (int)(endValue - fraction * (endValue - startValue));
    }
}