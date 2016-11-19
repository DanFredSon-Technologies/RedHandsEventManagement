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

public class BtlActivities extends AppCompatActivity {
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
        setContentView(R.layout.activity_btl_activities);

        textViewSelectedRequirements = (TextView) findViewById(R.id.textView_selected_requirements);
        buttonSendRequirements = (Button) findViewById(R.id.button_send_requirements);
        editTextEnterPhoneNumber = (EditText) findViewById(R.id.editText_enter_phone_number);
        editTextEnterMailId = (EditText) findViewById(R.id.editText_enter_mail_id);

        buttonSendRequirements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPhoneNumber = editTextEnterPhoneNumber.getText().toString();
                stringMailId = editTextEnterMailId.getText().toString();
                stringMessage = "Phn: \n" + stringPhoneNumber + "\nMail: \n" + stringMailId + "\nBTL: \n" + stringSelectedRequirementsForSms;
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
            case R.id.checkbox_mall_activities:
                if (checked) {
                    requirementsSelection.add("Mall Activities");
                    requirementsSelectionForSms.add("01");
                } else {
                    requirementsSelection.remove("Mall Activities");
                    requirementsSelectionForSms.remove("01");
                }
                break;
            case R.id.checkbox_road_shows:
                if (checked) {
                    requirementsSelection.add("Road Shows");
                    requirementsSelectionForSms.add("02");
                } else {
                    requirementsSelection.remove("Road Shows");
                    requirementsSelectionForSms.remove("02");
                }
                break;
            case R.id.checkbox_biker_activities:
                if (checked) {
                    requirementsSelection.add("Biker Activities");
                    requirementsSelectionForSms.add("03");
                } else {
                    requirementsSelection.remove("Biker Activities");
                    requirementsSelectionForSms.remove("03");
                }
                break;
            case R.id.checkbox_direct_sales_activities:
                if (checked) {
                    requirementsSelection.add("Direct Sales Activities");
                    requirementsSelectionForSms.add("04");
                } else {
                    requirementsSelection.remove("Direct Sales Activities");
                    requirementsSelectionForSms.remove("04");
                }
                break;
            case R.id.checkbox_leaflet_and_pamphlet_distribution:
                if (checked) {
                    requirementsSelection.add("Leaflet and Pamphlet Distribution");
                    requirementsSelectionForSms.add("05");
                } else {
                    requirementsSelection.remove("Leaflet and Pamphlet Distribution");
                    requirementsSelectionForSms.remove("05");
                }
                break;
            case R.id.checkbox_sample_distribution_in_schools_and_colleges:
                if (checked) {
                    requirementsSelection.add("Sample Distribution in Schools and Colleges");
                    requirementsSelectionForSms.add("06");
                } else {
                    requirementsSelection.remove("Sample Distribution in Schools and Colleges");
                    requirementsSelectionForSms.remove("06");
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