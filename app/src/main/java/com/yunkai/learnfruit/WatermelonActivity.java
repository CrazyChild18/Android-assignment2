package com.yunkai.learnfruit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class WatermelonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watermelon);

        SharedPreferences sharedPreferences=getSharedPreferences("Change",MODE_PRIVATE);
        boolean  change = sharedPreferences.getBoolean("change",false);
        TextView title = findViewById(R.id.watermelon_title);
        TextView sentence = findViewById(R.id.watermelon_sentence);
        ImageView imageView=findViewById(R.id.watermelon_header);

        if(change){
            title.setText(getString(R.string.watermelon_name_ch));
            sentence.setText(getString(R.string.watermelon_description_ch));
            imageView.setImageResource(R.drawable.w_chinese);
        }else{
            title.setText(getString(R.string.watermelon_name_en));
            sentence.setText(getString(R.string.watermelon_description_en));
            imageView.setImageResource(R.drawable.w);
        }
    }
}