package com.example.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import android.app.AlertDialog;
import android.widget.EditText;
import android.content.DialogInterface;
import android.content.Context;
import android.content.SharedPreferences;
import android.app.Activity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    View view;
    ArrayList<String> shoppingList = null;
    ArrayAdapter<String> adapter = null;
    ListView lv = null;

    //onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        shoppingList = getArrayVal(getApplicationContext());
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, shoppingList);
        lv =  findViewById(R.id.listView);
        lv.setAdapter(adapter);
        Intent intent = getIntent();
        int color = intent.getIntExtra("color", 0);
        Toast.makeText(MainActivity.this,String.valueOf(color), Toast.LENGTH_LONG).show();
        view= this.getWindow().getDecorView();
        if (color == 2){
            view.setBackgroundResource(R.color.Red);
        }
        if (color == 1 ) {
            view.setBackgroundResource(R.color.Blue);
        }
        if (color == 0) {
            view.setBackgroundResource(R.color.White);
        }

    }

    //Inflate the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    //Handle action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent myIntent = new Intent(MainActivity.this, SettingActivity.class);
            startActivityForResult(myIntent, 0);

        }
        if (id == R.id.action_add) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Add Item");
            final EditText input = new EditText(this);
            builder.setView(input);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    shoppingList.add(preferredCase(input.getText().toString()));
                    Collections.sort(shoppingList);
                    storeArrayVal(shoppingList, getApplicationContext());
                    lv.setAdapter(adapter);
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
            return true;
        }

        //Clear the shopping list
        if (id == R.id.action_clear) {
            shoppingList.clear();
            lv.setAdapter(adapter);
        }

        return super.onOptionsItemSelected(item);
    }
    //Set first letter uppercase, rest lower
    public static String preferredCase(String original)
    {
        if (original.isEmpty())
            return original;

        return original.substring(0, 1).toUpperCase() + original.substring(1).toLowerCase();
    }

    public static void storeArrayVal( ArrayList<String> inArrayList, Context context)
    {
        Set<String> WhatToWrite = new HashSet<>(inArrayList);
        SharedPreferences WordSearchPutPrefs = context.getSharedPreferences("dbArrayValues", Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = WordSearchPutPrefs.edit();
        prefEditor.putStringSet("myArray", WhatToWrite);
        prefEditor.apply();
    }

    public static ArrayList getArrayVal( Context dan)
    {
        SharedPreferences WordSearchGetPrefs = dan.getSharedPreferences("dbArrayValues",Activity.MODE_PRIVATE);
        Set<String> tempSet = new HashSet<>();
        tempSet = WordSearchGetPrefs.getStringSet("myArray", tempSet);
        return new ArrayList<>(tempSet);
    }
}

