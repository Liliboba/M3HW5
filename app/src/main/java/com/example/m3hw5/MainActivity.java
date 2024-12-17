package com.example.m3hw5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements InputFragment.OnMessageSendListener {

    private ChatFragment chatFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chatFragment = new ChatFragment();
        InputFragment inputFragment = new InputFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.chatFragmentContainer, chatFragment);
        transaction.replace(R.id.inputFragmentContainer, inputFragment);

        transaction.commit();
    }

    @Override
    public void onMessageSend(String message) {
        chatFragment.addMessage(message, true);
        chatFragment.addMessage("Привет, я Атай, а ты кто?", false);
    }
}
