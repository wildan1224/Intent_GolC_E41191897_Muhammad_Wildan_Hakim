package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class userDetailActivity extends AppCompatActivity {

    TextView nameAndAge, email, city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        nameAndAge = findViewById(R.id.name_and_age);
        email = findViewById(R.id.email);
        city = findViewById(R.id.city);

        user user = getIntent().getParcelableExtra("user");
        nameAndAge.setText(user.getName() + ", " + user.getAge());
        email.setText(user.getEmail());
        city.setText(user.getCity());
    }
}