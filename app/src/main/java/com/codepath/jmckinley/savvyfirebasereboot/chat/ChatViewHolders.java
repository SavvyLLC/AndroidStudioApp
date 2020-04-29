package com.codepath.jmckinley.savvyfirebasereboot.chat;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ChatViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView mMatchId, mMatchName;
    public ImageView mMatchImage;

    public ChatViewHolders(View itemView){
        super(itemView);
        itemView.setOnClickListener(this);
    }

    public void onClick(View view){

    }

}
