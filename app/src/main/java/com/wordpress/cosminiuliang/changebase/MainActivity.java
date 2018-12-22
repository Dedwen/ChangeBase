package com.wordpress.cosminiuliang.changebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button baseBtn1;
    private Button baseBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseBtn1 = (Button) findViewById(R.id.baseBtn1);
        baseBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
                baseBtn1.startAnimation(animation);

                startActivity1();
            }
        });

        baseBtn2 = (Button) findViewById(R.id.baseBtn2);
        baseBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
                baseBtn2.startAnimation(animation);

                startActivity2();
            }
        });

    }

    public void startActivity1() {

        Intent intent = new Intent(this, ChangeBase1.class);
        startActivity(intent);
    }

    public void startActivity2() {

        Intent intent = new Intent(this, ChangeBase2.class);
        startActivity(intent);
    }


}
