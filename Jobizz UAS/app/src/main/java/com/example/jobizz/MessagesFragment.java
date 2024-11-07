package com.example.jobizz;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;

import androidx.fragment.app.Fragment;

public class MessagesFragment extends Fragment {

    private TextInputEditText titleEditText;
    private TextInputEditText notesEditText;
    private Button saveButton;
    private TextView savedMessagesTextView;
    private Db_sqlite dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_messages, container, false);

        titleEditText = view.findViewById(R.id.tiet_title);
        notesEditText = view.findViewById(R.id.tiet_isi);
        saveButton = view.findViewById(R.id.msg_save);
        savedMessagesTextView = view.findViewById(R.id.tv_saved_messages);

        dbHelper = new Db_sqlite(getContext());

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveMessage();
                displaySavedMessages();
            }
        });

        // Menampilkan pesan yang sudah disimpan saat pertama kali fragment dibuat
        displaySavedMessages();

        return view;
    }

    private void saveMessage() {
        String title = titleEditText.getText().toString().trim();
        String notes = notesEditText.getText().toString().trim();

        if (!title.isEmpty() && !notes.isEmpty()) {
            dbHelper.addNote(title, notes);
            titleEditText.setText("");
            notesEditText.setText("");
        }
    }

    private void displaySavedMessages() {
        Cursor cursor = dbHelper.getSavedMessages();
        StringBuilder messageText = new StringBuilder();

        while (cursor.moveToNext()) {
            String title = cursor.getString(0);
            String notes = cursor.getString(1);
            messageText.append("Title: ").append(title).append("\nNotes: ").append(notes).append("\n\n");
        }

        savedMessagesTextView.setText(messageText.toString());
    }
}
