package com.danfredson.redhandseventmanagement;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sponsorship extends AppCompatActivity {
    EditText editTextEnterNameOfOrganization, editTextEnterPhoneNumber, editTextEnterMailId;
    Button buttonSendRequirements;
    String stringPhoneNumber,
            stringNameOfOrganization,
            stringMessage,
            stringMailId,
            stringSenderPhoneNumber = "9043821110";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsorship);

        buttonSendRequirements = (Button) findViewById(R.id.button_send_requirements);
        editTextEnterNameOfOrganization = (EditText) findViewById(R.id.editText_enter_name_of_organization);
        editTextEnterPhoneNumber = (EditText) findViewById(R.id.editText_enter_phone_number);
        editTextEnterMailId = (EditText) findViewById(R.id.editText_enter_mail_id);

        buttonSendRequirements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringNameOfOrganization = editTextEnterNameOfOrganization.getText().toString();
                stringPhoneNumber = editTextEnterPhoneNumber.getText().toString();
                stringMailId = editTextEnterMailId.getText().toString();
                stringMessage = "Org: \n" + stringNameOfOrganization + "\nPhn: \n" + stringPhoneNumber + "\nMail: \n" + stringMailId;
                sendSMS(stringSenderPhoneNumber, stringMessage);
            }
        });

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            Log.d("Red Hands", "Permission denied!");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 123);
        } else {
            Log.d("Red Hands", "Permission granted!");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 123) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d("Red Hands", "Permission granted!");
            } else {
                Log.d("Red Hands", "Permission denied!");
            }
        }
    }

    protected void sendSMS(String stringSenderPhoneNumber, String stringMessage) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(stringSenderPhoneNumber, null, stringMessage, null, null);
        Toast.makeText(this, "Sponsor Request Sent Successfully!", Toast.LENGTH_LONG).show();
    }
}
