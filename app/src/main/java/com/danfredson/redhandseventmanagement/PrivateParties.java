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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PrivateParties extends AppCompatActivity {
    ArrayList<String> requirementsSelection = new ArrayList<String>();
    ArrayList<String> requirementsSelectionForSms = new ArrayList<String>();
    TextView textViewSelectedRequirements;
    EditText editTextEnterPhoneNumber, editTextEnterMailId;
    Button buttonSendRequirements;
    String stringSelectedRequirements,
            stringSelectedRequirementsForSms = "",
            stringMessage,
            stringPhoneNumber,
            stringMailId,
            stringSenderPhoneNumber = "9043821110";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_parties);

        textViewSelectedRequirements = (TextView) findViewById(R.id.textView_selected_requirements);
        buttonSendRequirements = (Button) findViewById(R.id.button_send_requirements);
        editTextEnterPhoneNumber = (EditText) findViewById(R.id.editText_enter_phone_number);
        editTextEnterMailId = (EditText) findViewById(R.id.editText_enter_mail_id);

        buttonSendRequirements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPhoneNumber = editTextEnterPhoneNumber.getText().toString();
                stringMailId = editTextEnterMailId.getText().toString();
                stringMessage = "Phn: \n" + stringPhoneNumber + "\nMail: \n" + stringMailId + "\nPP: \n" + stringSelectedRequirementsForSms;
                sendSMS(stringSenderPhoneNumber, stringMessage);
            }
        });
        textViewSelectedRequirements.setEnabled(false);

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
        Toast.makeText(this, "Requirements Sent Successfully!", Toast.LENGTH_LONG).show();
    }

    public void selectRequirements(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkbox_pp_anchor:
                if (checked) {
                    requirementsSelection.add("Anchor");
                    requirementsSelectionForSms.add("01");
                } else {
                    requirementsSelection.remove("Anchor");
                    requirementsSelectionForSms.remove("01");
                }
                break;
            case R.id.checkbox_cocktail:
                if (checked) {
                    requirementsSelection.add("Cocktail");
                    requirementsSelectionForSms.add("02");
                } else {
                    requirementsSelection.remove("Cocktail");
                    requirementsSelectionForSms.remove("02");
                }
                break;
            case R.id.checkbox_dining:
                if (checked) {
                    requirementsSelection.add("Dining");
                    requirementsSelectionForSms.add("03");
                } else {
                    requirementsSelection.remove("Dining");
                    requirementsSelectionForSms.remove("03");
                }
                break;
            case R.id.checkbox_pp_dj_artists:
                if (checked) {
                    requirementsSelection.add("DJ Artists");
                    requirementsSelectionForSms.add("04");
                } else {
                    requirementsSelection.remove("DJ Artists");
                    requirementsSelectionForSms.remove("04");
                }
                break;
            case R.id.checkbox_juggling:
                if (checked) {
                    requirementsSelection.add("Juggling");
                    requirementsSelectionForSms.add("05");
                } else {
                    requirementsSelection.remove("Juggling");
                    requirementsSelectionForSms.remove("05");
                }
                break;
            case R.id.checkbox_mocktail:
                if (checked) {
                    requirementsSelection.add("Mocktail");
                    requirementsSelectionForSms.add("06");
                } else {
                    requirementsSelection.remove("Mocktail");
                    requirementsSelectionForSms.remove("06");
                }
                break;
            case R.id.checkbox_sounds_and_lightings:
                if (checked) {
                    requirementsSelection.add("Sounds and Lightings");
                    requirementsSelectionForSms.add("07");
                } else {
                    requirementsSelection.remove("Sounds and Lightings");
                    requirementsSelectionForSms.remove("07");
                }
                break;
            case R.id.checkbox_themed_parties:
                if (checked) {
                    requirementsSelection.add("Themed Parties");
                    requirementsSelectionForSms.add("08");
                } else {
                    requirementsSelection.remove("Themed Parties");
                    requirementsSelectionForSms.remove("08");
                }
                break;
        }
    }

    public void checkRequirements(View view) {
        stringSelectedRequirements = "";
        for (String selections : requirementsSelection) {
            stringSelectedRequirements = stringSelectedRequirements + selections + "\n";
        }
        for (String selectionsForSms : requirementsSelectionForSms) {
            stringSelectedRequirementsForSms = stringSelectedRequirementsForSms + selectionsForSms + "\n";
        }
        textViewSelectedRequirements.setText(stringSelectedRequirements);
        textViewSelectedRequirements.setEnabled(true);
    }
}
