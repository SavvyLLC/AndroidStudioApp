package com.codepath.jmckinley.savvyfirebasereboot.chat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.codepath.jmckinley.savvyfirebasereboot.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView mRecylerView;
    private RecyclerView.Adapter mChatAdapter;
    private RecyclerView.LayoutManager mChatLayoutManager;

    private EditText mSendEditText;

    private Button mSendButton;

    private String currentUserId, matchId;

    DatabaseReference mDatabaseUser, mDatabaseChat;

    String chatId = "testRoom";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

            currentUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();
            matchId = FirebaseDatabase.getInstance().getReference().child("chats").child("roomId").push().getKey();

            //TODO Check for spots that got instance of current user and include
            //call to the current user method
            currentUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();

            mDatabaseChat = FirebaseDatabase.getInstance().getReference().child("chats").child("roomId").child(chatId);

            mRecylerView = (RecyclerView)findViewById(R.id.recyclerView);
            mRecylerView.setNestedScrollingEnabled(false);
            mRecylerView.setHasFixedSize(false);
            mChatLayoutManager = new LinearLayoutManager(ChatActivity.this);
            mRecylerView.setLayoutManager((mChatLayoutManager));
            mChatAdapter = new ChatAdapter(getDataSetChat(), ChatActivity.this);
            mRecylerView.setAdapter(mChatAdapter);

            mSendEditText = findViewById(R.id.message);
            mSendButton = findViewById(R.id.send);

            mSendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sendMessage();
                }
            });

            getChatMessages();
    }

    private void sendMessage(){
        String sendMessageText = mSendEditText.getText().toString();

        if(!sendMessageText.isEmpty()){
            DatabaseReference newMessageDb = mDatabaseChat.push();

            Map newMessage = new HashMap<>();
            newMessage.put("createdByUser", currentUserId);
            newMessage.put("text", sendMessageText);

            newMessageDb.setValue(newMessage);
        }

        mSendEditText.setText(null);
    }

    private void getChatMessages(){
        mDatabaseChat.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                if(dataSnapshot.exists()){
                    String message = null;
                    String createdByUser = null;

                    if(dataSnapshot.child("text").getValue() != null){
                        message = dataSnapshot.child("text").getValue().toString();
                    }
                    if(dataSnapshot.child("createdByUser").getValue() != null){
                        createdByUser = dataSnapshot.child("createdByUser").getValue().toString();
                    }

                    if(message != null && createdByUser != null){
                        Boolean currentUserBoolean = false;
                        if(createdByUser.equals(currentUserId)){
                            currentUserBoolean = true;
                        }

                        ChatObject newMessage = new ChatObject(message, currentUserBoolean);
                        resultsChat.add(newMessage);
                        mChatAdapter.notifyDataSetChanged();

                    }
                }

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    //TODO CREATE DYNAMIC GROUP CHATS BETWEEN USERS

    private ArrayList<ChatObject> resultsChat = new ArrayList<ChatObject>();
    private List<ChatObject> getDataSetChat() { return resultsChat; }

}

