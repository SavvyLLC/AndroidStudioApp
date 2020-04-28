package com.codepath.jmckinley.savvyfirebasereboot.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.jmckinley.savvyfirebasereboot.Models.Cards;
import com.codepath.jmckinley.savvyfirebasereboot.R;

import java.util.List;

public class arrayAdapter extends ArrayAdapter<Cards>{

    Context context;
    public arrayAdapter(Context context, int resourceId, List<Cards> items){
        super(context, resourceId, items);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Cards card_item = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);

        }

        TextView name = (TextView) convertView.findViewById(R.id.helloText);
        ImageView image = (ImageView) convertView.findViewById(R.id.resumeViewMainActvity);


        name.setText(card_item.getName());
        image.setImageResource(R.mipmap.ic_launcher);


        return  convertView;
    }
}
