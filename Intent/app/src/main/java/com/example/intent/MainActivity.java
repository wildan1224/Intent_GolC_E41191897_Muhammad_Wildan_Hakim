package com.example.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMoveActivity, btnMoveData, btnMoveObject, btnDialNumber, btnMaps, btnShareText, btnSms, btnContact, btnResult;
    private static final int REQUEST_CODE = 75;
    private static final int PICK_CONTACT_REQUEST = 1;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        btnMoveData = findViewById(R.id.btn_move_activity_data);
        btnMoveData.setOnClickListener(this);

        btnMoveObject = findViewById(R.id.btn_move_activity_object);
        btnMoveObject.setOnClickListener(this);

        btnDialNumber = findViewById(R.id.btn_dial_a_number);
        btnDialNumber.setOnClickListener(this);

        btnMaps = findViewById(R.id.btn_maps);
        btnMaps.setOnClickListener(this);

        btnShareText = findViewById(R.id.btn_share_text);
        btnShareText.setOnClickListener(this);

        btnSms = findViewById(R.id.btn_sms);
        btnSms.setOnClickListener(this);

        btnContact = findViewById(R.id.btn_contact);
        btnContact.setOnClickListener(this);

        btnResult = findViewById(R.id.btn_activity_result);
        btnResult.setOnClickListener(this);

        textViewResult = findViewById(R.id.textViewResult);


    }


    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move_activity:
                Intent intentPindahActivity = new Intent(this, MoveActivity.class);
                startActivity(intentPindahActivity);
                break;
            case R.id.btn_move_activity_data:
                Intent moveWithDataIntent = new Intent(this, MoveWithDataActivity.class);
                moveWithDataIntent.putExtra("extra_name", "Muhammad Wildan Hakim");
                moveWithDataIntent.putExtra("NIM", "E411911897");
                startActivity(moveWithDataIntent);
                break;
            case R.id.btn_move_activity_object:
                Intent intentPindahActivityObject = new Intent(this, MoveWithObject.class);
                startActivity(intentPindahActivityObject);
                break;
            case R.id.btn_dial_a_number:
                String phoneNumber = "085648627461";
                Intent dialphone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialphone);
                break;
            case R.id.btn_maps:
                Uri gmmIntentUri = Uri.parse("https://www.google.com/maps/dir//State+Polytechnic+of+Jember,+Jl.+Mastrip+No.164,+Krajan+Timur,+Sumbersari,+Jember+Regency,+East+Java+68121/@-8.1781017,113.6986263,15z/data=!4m8!4m7!1m0!1m5!1m1!1s0x2dd695b617d8f623:0xf6c4437632474338!2m2!1d113.7224597!2d-8.1594771");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
                break;
            case R.id.btn_share_text:
                Intent share = new Intent(Intent.ACTION_SEND);
                share.putExtra(Intent.EXTRA_TEXT, "Mari Belajar Android ");
                share.setType("text/plain");
                startActivity(Intent.createChooser(share, "share link"));
                break;
            case R.id.btn_sms:
                Intent sms = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto: 085648627461"));
                sms.putExtra("sms_body", "Assalamualaikum");
                startActivity(sms);
                break;
            case R.id.btn_contact:
                Intent pickContact = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
                pickContact.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(pickContact, PICK_CONTACT_REQUEST);
                break;
            case R.id.btn_activity_result:
                Intent moveForResultIntent = new Intent(this, MoveForResultActivity.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_CONTACT_REQUEST){
            if (resultCode == RESULT_OK){
                Uri contactUri = data.getData();
                String []projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};

                Cursor cursor = getContentResolver().query(contactUri, projection, null, null, null);
                cursor.moveToFirst();

                int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(column);
                textViewResult.setText(number);
            }
        }
        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveForResultActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_VALUE, 0);
                textViewResult.setText("Hasil: "+selectedValue);
            }
        }
    }
}