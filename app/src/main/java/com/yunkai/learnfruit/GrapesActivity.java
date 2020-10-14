package com.yunkai.learnfruit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GrapesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grapes);

        SharedPreferences sharedPreferences=getSharedPreferences("Change",MODE_PRIVATE);
        boolean  change = sharedPreferences.getBoolean("change",false);
        TextView title = findViewById(R.id.grapes_title);
        TextView sentence = findViewById(R.id.grapes_sentence);
        ImageView imageView=findViewById(R.id.grapes_header);

        if(change){
            title.setText(getString(R.string.grape_name_ch));
            sentence.setText(getString(R.string.grape_description_ch));
            imageView.setImageResource(R.drawable.g_chinese);
        }else{
            title.setText(getString(R.string.grape_name_en));
            sentence.setText(getString(R.string.grape_description_en));
            imageView.setImageResource(R.drawable.g);
        }
    }
}