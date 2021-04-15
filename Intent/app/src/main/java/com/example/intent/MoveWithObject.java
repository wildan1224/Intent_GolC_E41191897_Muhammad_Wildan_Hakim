package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MoveWithObject extends AppCompatActivity implements View.OnClickListener {

    private EditText name, age, email, city;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        email = findViewById(R.id.email);
        city = findViewById(R.id.city);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submit) {
            String inputName = name.getText().toString().trim();
            String inputAge = age.getText().toString();
            int finalValue=Integer.parseInt(inputAge);
            String inputEmail = email.getText().toString().trim();
            String inputCity = city.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(inputName)) {
                isEmptyFields = true;
                name.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputAge)) {
                isEmptyFields = true;
                age.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputEmail)) {
                isEmptyFields = true;
                email.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputCity)) {
                isEmptyFields = true;
                city.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                user usr = new user(inputName, finalValue, inputEmail, inputCity);

                Intent intent = new Intent(MoveWithObject.this, userDetailActivity.class);
                intent.putExtra("user", usr);
                startActivity(intent);
            }
        }
    }
}