package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveWithDataActivity extends AppCompatActivity {

    private TextView tvdataintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_data);

        tvdataintent = findViewById(R.id.tvdataintent);

        String nama = getIntent().getStringExtra("extra_name");
        String NIM = getIntent().getStringExtra("NIM");
        String text = "Nama: "+nama+", NIM: "+ NIM;
        tvdataintent.setText(text);
    }
}