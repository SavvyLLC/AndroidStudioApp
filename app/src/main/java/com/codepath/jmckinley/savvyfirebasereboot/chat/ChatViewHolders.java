package com.codepath.jmckinley.savvyfirebasereboot.chat;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.codepath.jmckinley.savvyfirebasereboot.R;

public class ChatViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView mMessage;
    public LinearLayout mContainer;

    public ChatViewHolders(View itemView){
        super(itemView);
        itemView.setOnClickListener(this);

        mMessage = itemView.findViewById(R.id.chatMessage);
        mContainer = itemView.findViewById(R.id.messageContainer);
    }

    public void onClick(View view){

    }

}
