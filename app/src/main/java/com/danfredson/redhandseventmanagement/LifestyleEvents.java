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

public class LifestyleEvents extends AppCompatActivity {
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
        setContentView(R.layout.activity_lifestyle_events);

        textViewSelectedRequirements = (TextView) findViewById(R.id.textView_selected_requirements);
        buttonSendRequirements = (Button) findViewById(R.id.button_send_requirements);
        editTextEnterPhoneNumber = (EditText) findViewById(R.id.editText_enter_phone_number);
        editTextEnterMailId = (EditText) findViewById(R.id.editText_enter_mail_id);

        buttonSendRequirements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPhoneNumber = editTextEnterPhoneNumber.getText().toString();
                stringMailId = editTextEnterMailId.getText().toString();
                stringMessage = "Phn: \n" + stringPhoneNumber + "\nMail: \n" + stringMailId + "\nLE: \n" + stringSelectedRequirementsForSms;
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
            case R.id.checkbox_fashion_shows:
                if (checked) {
                    requirementsSelection.add("Fashion Shows");
                    requirementsSelectionForSms.add("01");
                } else {
                    requirementsSelection.remove("Fashion Shows");
                    requirementsSelectionForSms.remove("01");
                }
                break;
            case R.id.checkbox_premium_product_launches_and_showcases:
                if (checked) {
                    requirementsSelection.add("Premium Product Launches and Showcases");
                    requirementsSelectionForSms.add("02");
                } else {
                    requirementsSelection.remove("Premium Product Launches and Showcases");
                    requirementsSelectionForSms.remove("02");
                }
                break;
            case R.id.checkbox_exclusive_media_showings:
                if (checked) {
                    requirementsSelection.add("Exclusive Media Showings");
                    requirementsSelectionForSms.add("03");
                } else {
                    requirementsSelection.remove("Exclusive Media Showings");
                    requirementsSelectionForSms.remove("03");
                }
                break;
            case R.id.checkbox_film_launches:
                if (checked) {
                    requirementsSelection.add("Film Launches");
                    requirementsSelectionForSms.add("04");
                } else {
                    requirementsSelection.remove("Film Launches");
                    requirementsSelectionForSms.remove("04");
                }
                break;
            case R.id.checkbox_television_show_launches:
                if (checked) {
                    requirementsSelection.add("Television Show Launches");
                    requirementsSelectionForSms.add("05");
                } else {
                    requirementsSelection.remove("Television Show Launches");
                    requirementsSelectionForSms.remove("05");
                }
                break;
            case R.id.checkbox_concerts_and_stage_shows:
                if (checked) {
                    requirementsSelection.add("Concerts and Stage Shows");
                    requirementsSelectionForSms.add("06");
                } else {
                    requirementsSelection.remove("Concerts and Stage Shows");
                    requirementsSelectionForSms.remove("06");
                }
                break;
            case R.id.checkbox_milestone_celebations:
                if (checked) {
                    requirementsSelection.add("Milestone Celebrations");
                    requirementsSelectionForSms.add("07");
                } else {
                    requirementsSelection.remove("Milestone Celebrations");
                    requirementsSelectionForSms.remove("07");
                }
                break;
            case R.id.checkbox_theme_celebrations:
                if (checked) {
                    requirementsSelection.add("Theme Celebrations");
                    requirementsSelectionForSms.add("08");
                } else {
                    requirementsSelection.remove("Theme Celebrations");
                    requirementsSelectionForSms.remove("08");
                }
                break;
            case R.id.checkbox_musical_performances:
                if (checked) {
                    requirementsSelection.add("Musical Performances");
                    requirementsSelectionForSms.add("09");
                } else {
                    requirementsSelection.remove("Musical Performances");
                    requirementsSelectionForSms.remove("09");
                }
                break;
            case R.id.checkbox_exclusice_by_invite_only_events:
                if (checked) {
                    requirementsSelection.add("Exclusive ‘By Invite Only’ Events");
                    requirementsSelectionForSms.add("10");
                } else {
                    requirementsSelection.remove("Exclusive ‘By Invite Only’ Events");
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
