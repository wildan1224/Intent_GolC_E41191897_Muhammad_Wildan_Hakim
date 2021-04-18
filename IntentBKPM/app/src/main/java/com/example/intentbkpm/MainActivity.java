package com.example.intentbkpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnImp, btnExp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnImp = findViewById(R.id.btn_implicit);
        btnImp.setOnClickListener(this);

        btnExp = findViewById(R.id.btn_explicit);
        btnExp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_implicit:
                Intent IntentImp = new Intent(this, Implicit.class);
                startActivity(IntentImp);
                break;
            case R.id.btn_explicit:
                Intent IntentExp = new Intent(this, Explicit.class);
                startActivity(IntentExp);
                break;
        }

    }
}