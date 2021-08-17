package com.ripalay.hw_android1_less_2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private MaterialButton share;
    private EditText mail;
    private EditText thema;
    private EditText text;
    private Button open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail = findViewById(R.id.ed_mail);
        thema = findViewById(R.id.ed_thema);
        text = findViewById(R.id.ed_text);
        share = findViewById(R.id.btn_share);
        open = findViewById(R.id.btn_open);
        share.setOnClickListener(v -> {
            String themaSend = thema.getText().toString();
            String textSend = text.getText().toString();
            String mailSend = mail.getText().toString();
            if (!textSend.equals("") && !themaSend.equals("") && !mailSend.equals("")) {
                Log.d("shmala", textSend);
                Intent shareIntent = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
                shareIntent.setType("plan/text");
                shareIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{mailSend});
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, themaSend);
                shareIntent.putExtra(Intent.EXTRA_TEXT, textSend);


                startActivity(shareIntent);
            } else {
                Toast.makeText(this, "Необходимо заполнить все поля", Toast.LENGTH_SHORT).show();
            }
        });
        open.setOnClickListener(v -> {
            String textSend = text.getText().toString();
            Intent search = new Intent(Intent.ACTION_WEB_SEARCH);
            search.putExtra(SearchManager.QUERY, textSend);
            startActivity(search);
        });

    }
}