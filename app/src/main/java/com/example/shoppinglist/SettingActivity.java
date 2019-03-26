package com.example.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class SettingActivity extends MainActivity {
    View view;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //view= this.getWindow().getDecorView();
        //view.setBackgroundResource(R.color.Blue);

        Button next = (Button) findViewById(R.id.setting_button);
        //String backgroundColor =  String.valueOf(R.id.setting_spinner);
        //Spinner settingSpinner = (Spinner) findViewById(R.id.setting_spinner);
        //final String bColor = String.valueOf(settingSpinner.getSelectedItem());

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //view.setBackgroundResource(Integer.parseInt(bColor));
                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                startActivityForResult(intent, 0);

            }



        });


    }

}
