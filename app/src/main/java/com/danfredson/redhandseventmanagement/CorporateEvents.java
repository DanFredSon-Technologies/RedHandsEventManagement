package com.danfredson.redhandseventmanagement;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CorporateEvents extends AppCompatActivity {
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
        setContentView(R.layout.activity_corporate_events);

        textViewSelectedRequirements = (TextView) findViewById(R.id.textView_selected_requirements);
        buttonSendRequirements = (Button) findViewById(R.id.button_send_requirements);
        editTextEnterPhoneNumber = (EditText) findViewById(R.id.editText_enter_phone_number);
        editTextEnterMailId = (EditText) findViewById(R.id.editText_enter_mail_id);

        buttonSendRequirements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPhoneNumber = editTextEnterPhoneNumber.getText().toString();
                stringMailId = editTextEnterMailId.getText().toString();
                stringMessage = "Phn: \n" + stringPhoneNumber + "\nMail: \n" + stringMailId + "\nCE: \n" + stringSelectedRequirementsForSms;
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
            case R.id.checkbox_conferences:
                if (checked) {
                    requirementsSelection.add("Conferences");
                    requirementsSelectionForSms.add("01");
                } else {
                    requirementsSelection.remove("Conferences");
                    requirementsSelectionForSms.remove("01");
                }
                break;
            case R.id.checkbox_seminars:
                if (checked) {
                    requirementsSelection.add("Seminars");
                    requirementsSelectionForSms.add("02");
                } else {
                    requirementsSelection.remove("Seminars");
                    requirementsSelectionForSms.remove("02");
                }
                break;
            case R.id.checkbox_meetings:
                if (checked) {
                    requirementsSelection.add("Meetings");
                    requirementsSelectionForSms.add("03");
                } else {
                    requirementsSelection.remove("Meetings");
                    requirementsSelectionForSms.remove("03");
                }
                break;
            case R.id.checkbox_team_building_events:
                if (checked) {
                    requirementsSelection.add("Team Building Events");
                    requirementsSelectionForSms.add("04");
                } else {
                    requirementsSelection.remove("Team Building Events");
                    requirementsSelectionForSms.remove("04");
                }
                break;
            case R.id.checkbox_trade_shows:
                if (checked) {
                    requirementsSelection.add("Trade Shows");
                    requirementsSelectionForSms.add("05");
                } else {
                    requirementsSelection.remove("Trade Shows");
                    requirementsSelectionForSms.remove("05");
                }
                break;
            case R.id.checkbox_business_dinners:
                if (checked) {
                    requirementsSelection.add("Business Dinners");
                    requirementsSelectionForSms.add("06");
                } else {
                    requirementsSelection.remove("Business Dinners");
                    requirementsSelectionForSms.remove("06");
                }
                break;
            case R.id.checkbox_press_conferences:
                if (checked) {
                    requirementsSelection.add("Press Conferences");
                    requirementsSelectionForSms.add("07");
                } else {
                    requirementsSelection.remove("Press Conferences");
                    requirementsSelectionForSms.remove("07");
                }
                break;
            case R.id.checkbox_networking_events:
                if (checked) {
                    requirementsSelection.add("Networking Events");
                    requirementsSelectionForSms.add("08");
                } else {
                    requirementsSelection.remove("Networking Events");
                    requirementsSelectionForSms.remove("08");
                }
                break;
            case R.id.checkbox_opening_ceremonies:
                if (checked) {
                    requirementsSelection.add("Opening Ceremonies");
                    requirementsSelectionForSms.add("09");
                } else {
                    requirementsSelection.remove("Opening Ceremonies");
                    requirementsSelectionForSms.remove("09");
                }
                break;
            case R.id.checkbox_product_launches:
                if (checked) {
                    requirementsSelection.add("Product Launches");
                    requirementsSelectionForSms.add("10");
                } else {
                    requirementsSelection.remove("Product Launches");
                    requirementsSelectionForSms.remove("10");
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
