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

public class Inaugurations extends AppCompatActivity {
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
        setContentView(R.layout.activity_inaugurations);

        textViewSelectedRequirements = (TextView) findViewById(R.id.textView_selected_requirements);
        buttonSendRequirements = (Button) findViewById(R.id.button_send_requirements);
        editTextEnterPhoneNumber = (EditText) findViewById(R.id.editText_enter_phone_number);
        editTextEnterMailId = (EditText) findViewById(R.id.editText_enter_mail_id);

        buttonSendRequirements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPhoneNumber = editTextEnterPhoneNumber.getText().toString();
                stringMailId = editTextEnterMailId.getText().toString();
                stringMessage = "Phn: \n" + stringPhoneNumber + "\nMail: \n" + stringMailId + "\nIn: \n" + stringSelectedRequirementsForSms;
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
            case R.id.checkbox_chanda_melam:
                if (checked) {
                    requirementsSelection.add("Chanda Melam");
                    requirementsSelectionForSms.add("01");
                } else {
                    requirementsSelection.remove("Chanda Melam");
                    requirementsSelectionForSms.remove("01");
                }
                break;
            case R.id.checkbox_decorations:
                if (checked) {
                    requirementsSelection.add("Decorations");
                    requirementsSelectionForSms.add("02");
                } else {
                    requirementsSelection.remove("Decorations");
                    requirementsSelectionForSms.remove("02");
                }
                break;
            case R.id.checkbox_inauguration_emcee:
                if (checked) {
                    requirementsSelection.add("Emcee");
                    requirementsSelectionForSms.add("03");
                } else {
                    requirementsSelection.remove("Emcee");
                    requirementsSelectionForSms.remove("03");
                }
                break;
            case R.id.checkbox_refreshments:
                if (checked) {
                    requirementsSelection.add("Refreshments");
                    requirementsSelectionForSms.add("04");
                } else {
                    requirementsSelection.remove("Refreshments");
                    requirementsSelectionForSms.remove("04");
                }
                break;
            case R.id.checkbox_stage_shows:
                if (checked) {
                    requirementsSelection.add("Stage Shows");
                    requirementsSelectionForSms.add("05");
                } else {
                    requirementsSelection.remove("Stage Shows");
                    requirementsSelectionForSms.remove("05");
                }
                break;
            case R.id.checkbox_welcome_dolls:
                if (checked) {
                    requirementsSelection.add("Welcome Dolls");
                    requirementsSelectionForSms.add("06");
                } else {
                    requirementsSelection.remove("Welcome Dolls");
                    requirementsSelectionForSms.remove("06");
                }
                break;
            case R.id.checkbox_welcome_girls:
                if (checked) {
                    requirementsSelection.add("Welcome Girls");
                    requirementsSelectionForSms.add("07");
                } else {
                    requirementsSelection.remove("Welcome Girls");
                    requirementsSelectionForSms.remove("07");
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