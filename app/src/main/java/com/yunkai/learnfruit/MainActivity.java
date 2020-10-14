package com.yunkai.learnfruit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //The default is false and the default language is English
    private boolean isChinese = false;
    //Define myFruit list
    private List<fruit> myFruit = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Gets the current system language
        Locale language = getResources().getConfiguration().locale;

        //Create sp to store isChinese variables to record the user's choice of language
        SharedPreferences sharedPreferences = getSharedPreferences("Change", MODE_PRIVATE);
        isChinese = sharedPreferences.getBoolean("change", false);

        //Define the toggle language button
        FloatingActionButton btn_change = findViewById(R.id.change);
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChinese =! isChinese;
                SharedPreferences.Editor editor = getSharedPreferences("Change", MODE_PRIVATE).edit();
                editor.putBoolean("change", isChinese);
                editor.apply();
                if(isChinese){
                    Snackbar.make(view, "语言转化为中文", Snackbar.LENGTH_LONG).show();
                }else{
                    Snackbar.make(view, "Choose English as your language", Snackbar.LENGTH_LONG).show();
                }
                //Initialization list
                onResume();
            }
        });
    }

    //Displays the list of main screens
    //Select the onResume function here
    //A custom function causes the main interface to wait for the user to select it before displaying the list
    //Using the onResume function, you can call this method when the activity is ready to interact with the user
    //The activity at this point must be on top of the return stack and in a running state
    public void onResume() {
        super.onResume();
        myFruit = new ArrayList<>();
        initList(isChinese);
        ListView main_List = findViewById(R.id.main_list);
        FruitAdapter fruitAdapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, myFruit);
        main_List.setAdapter(fruitAdapter);

        main_List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(MainActivity.this, AppleActivity.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    Intent intent = new Intent(MainActivity.this, BananaActivity.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    Intent intent = new Intent(MainActivity.this, WatermelonActivity.class);
                    startActivity(intent);
                }
                if (i == 3) {
                    Intent intent = new Intent(MainActivity.this, CherryActivity.class);
                    startActivity(intent);
                }
                if (i == 4) {
                    Intent intent = new Intent(MainActivity.this, GrapesActivity.class);
                    startActivity(intent);
                }
                if (i == 5) {
                    Intent intent = new Intent(MainActivity.this, PearActivity.class);
                    startActivity(intent);
                }
                if (i == 6) {
                    Intent intent = new Intent(MainActivity.this, PineappleActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    //初始化列表文字内容
    public void initList(Boolean isChinese){
        if(isChinese){
            fruit apple = new fruit(getString(R.string.apple_name_ch), R.drawable.apple);
            myFruit.add(apple);
            fruit banana = new fruit(getString(R.string.banana_name_ch),R.drawable.banana);
            myFruit.add(banana);
            fruit watermelon = new fruit(getString(R.string.watermelon_name_ch),R.drawable.watermelon);
            myFruit.add(watermelon);
            fruit cherry = new fruit(getString(R.string.cherry_name_ch),R.drawable.cherry);
            myFruit.add(cherry);
            fruit grapes = new fruit(getString(R.string.grape_name_ch),R.drawable.grapes);
            myFruit.add(grapes);
            fruit pear = new fruit(getString(R.string.pear_name_ch),R.drawable.pear);
            myFruit.add(pear);
            fruit pineapple = new fruit(getString(R.string.pineapple_name_ch),R.drawable.pineapple);
            myFruit.add(pineapple);
        }else{
            fruit apple = new fruit(getString(R.string.apple_name_en), R.drawable.apple);
            myFruit.add(apple);
            fruit banana = new fruit(getString(R.string.banana_name_en),R.drawable.banana);
            myFruit.add(banana);
            fruit watermelon = new fruit(getString(R.string.watermelon_name_en),R.drawable.watermelon);
            myFruit.add(watermelon);
            fruit cherry = new fruit(getString(R.string.cherry_name_en),R.drawable.cherry);
            myFruit.add(cherry);
            fruit grapes = new fruit(getString(R.string.grape_name_en),R.drawable.grapes);
            myFruit.add(grapes);
            fruit pear = new fruit(getString(R.string.pear_name_en),R.drawable.pear);
            myFruit.add(pear);
            fruit pineapple = new fruit(getString(R.string.pineapple_name_en),R.drawable.pineapple);
            myFruit.add(pineapple);
        }
    }

}