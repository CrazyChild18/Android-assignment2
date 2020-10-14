package com.yunkai.learnfruit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<fruit> {
    private int resourceID;
    public FruitAdapter(Context context, int textViewResourceID, List<fruit> objects) {
        super(context, textViewResourceID, objects);
        resourceID=textViewResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        fruit f = getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
        ImageView fruitImage = view.findViewById(R.id.fruit_image);
        TextView fruitName = view.findViewById(R.id.fruit_name);
        fruitImage.setImageResource(f.getImageID());
        fruitName.setText(f.getName());
        return view;
    }
}
