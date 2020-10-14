package com.yunkai.learnfruit;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BananaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banana);

        SharedPreferences sharedPreferences=getSharedPreferences("Change",MODE_PRIVATE);
        boolean  change = sharedPreferences.getBoolean("change",false);
        TextView title = findViewById(R.id.banana_title);
        TextView sentence = findViewById(R.id.banana_sentence);
        ImageView imageView=findViewById(R.id.banana_header);

        if(change){
            title.setText(getString(R.string.banana_name_ch));
            sentence.setText(getString(R.string.banana_description_ch));
            imageView.setImageResource(R.drawable.b_chinese);
        }else{
            title.setText(getString(R.string.banana_name_en));
            sentence.setText(getString(R.string.banana_description_en));
            imageView.setImageResource(R.drawable.b);
        }
    }
}