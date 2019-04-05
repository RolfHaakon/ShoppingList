package com.example.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.Objects;


public class SettingActivity extends MainActivity {
    View view;
    Button buttonWhite;
    Button buttonRed;
    Button buttonBlue;
    Button buttonYellow;
    int color;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        view= this.getWindow().getDecorView();
        //Intent intent = getIntent();
        //int color = intent.getIntExtra("color", 0);
        if (color == 2){
            view.setBackgroundResource(R.color.Red);
        }
        if (color == 1 ) {
            view.setBackgroundResource(R.color.Blue);
        }
        if (color == 0) {
            view.setBackgroundResource(R.color.White);
        }
        if (color == 3) {
            view.setBackgroundResource(R.color.Yellow);
        }

        buttonWhite = findViewById(R.id.button_white);
        buttonRed = findViewById(R.id.button_red);
        buttonBlue = findViewById(R.id.button_blue);
        buttonYellow = findViewById(R.id.button_yellow);
        Button next = findViewById(R.id.setting_button);



        buttonWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = 0;
                //view.setBackgroundColor(Color.WHITE);
                view.setBackgroundResource(R.color.White);

            }
        });

        buttonYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = 3;
                //view.setBackgroundColor(Color.RED);
                view.setBackgroundResource(R.color.Yellow);
            }
        });
        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = 2;
                //view.setBackgroundColor(Color.RED);
                view.setBackgroundResource(R.color.Red);
            }
        });


        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = 1;
                //view.setBackgroundColor(R.color.Blue);
                view.setBackgroundResource(R.color.Blue);

            }
        });



        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                intent.putExtra("color", color);
                startActivityForResult(intent,0);

            }



        });


    }

}

