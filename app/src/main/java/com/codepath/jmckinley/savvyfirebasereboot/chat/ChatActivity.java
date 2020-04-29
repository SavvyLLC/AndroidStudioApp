package com.codepath.jmckinley.savvyfirebasereboot.chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.codepath.jmckinley.savvyfirebasereboot.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView mRecylerView;
    private RecyclerView.Adapter mChatAdapter;
    private RecyclerView.LayoutManager mChatLayoutManager;

    private String currentUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

            //TODO Check for spots that got instance of current user and include
            //call to the current user method
            currentUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();

            mRecylerView = (RecyclerView)findViewById(R.id.recyclerView);
            mRecylerView.setNestedScrollingEnabled(false);
            mRecylerView.setHasFixedSize(true);
            mChatLayoutManager = new LinearLayoutManager(ChatActivity.this);
            mRecylerView.setLayoutManager((mChatLayoutManager));
            mChatAdapter = new ChatAdapter(getDataSetChat(), ChatActivity.this);
            mRecylerView.setAdapter(mChatAdapter);
    }

    private ArrayList<ChatObject> resultsChat = new ArrayList<ChatObject>();
    private List<ChatObject> getDataSetChat() { return resultsChat; }


}

