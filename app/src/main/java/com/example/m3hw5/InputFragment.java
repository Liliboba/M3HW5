package com.example.m3hw5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class InputFragment extends Fragment {

    private OnMessageSendListener listener;

    public interface OnMessageSendListener {
        void onMessageSend(String message);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnMessageSendListener) {
            listener = (OnMessageSendListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnMessageSendListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);

        EditText messageInput = view.findViewById(R.id.messageInput);
        Button sendButton = view.findViewById(R.id.sendButton);

        sendButton.setOnClickListener(v -> {
            String message = messageInput.getText().toString().trim();
            if (!message.isEmpty()) {
                listener.onMessageSend(message);
                messageInput.setText("");
            }
        });

        return view;
    }
}
