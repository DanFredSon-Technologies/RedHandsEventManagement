package com.danfredson.redhandseventmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CelebrityManagement extends AppCompatActivity {
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
        setContentView(R.layout.activity_celebrity_management);

        textViewSelectedRequirements = (TextView) findViewById(R.id.textView_selected_requirements);
        buttonSendRequirements = (Button) findViewById(R.id.button_send_requirements);
        editTextEnterPhoneNumber = (EditText) findViewById(R.id.editText_enter_phone_number);
        editTextEnterMailId = (EditText) findViewById(R.id.editText_enter_mail_id);

        buttonSendRequirements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPhoneNumber = editTextEnterPhoneNumber.getText().toString();
                stringMailId = editTextEnterMailId.getText().toString();
                stringMessage = "Phn: \n" + stringPhoneNumber + "\nMail: \n" + stringMailId + "\nCM: \n" + stringSelectedRequirementsForSms;
                sendSMS(stringSenderPhoneNumber, stringMessage);
            }
        });
        textViewSelectedRequirements.setEnabled(false);
    }

    protected void sendSMS(String stringSenderPhoneNumber, String stringMessage) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(stringSenderPhoneNumber, null, stringMessage, null, null);
        Toast.makeText(this, "Requirements Sent Successfully!", Toast.LENGTH_LONG).show();
    }

    public void selectRequirements(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkbox_dancers:
                if (checked) {
                    requirementsSelection.add("Dancers");
                    requirementsSelectionForSms.add("01");
                } else {
                    requirementsSelection.remove("Dancers");
                    requirementsSelectionForSms.remove("01");
                }
                break;
            case R.id.checkbox_dj_artists:
                if (checked) {
                    requirementsSelection.add("DJ Artists");
                    requirementsSelectionForSms.add("02");
                } else {
                    requirementsSelection.remove("DJ Artists");
                    requirementsSelectionForSms.remove("02");
                }
                break;
            case R.id.checkbox_mimicry_artists:
                if (checked) {
                    requirementsSelection.add("Mimicry Artists");
                    requirementsSelectionForSms.add("03");
                } else {
                    requirementsSelection.remove("Mimicry Artists");
                    requirementsSelectionForSms.remove("03");
                }
                break;
            case R.id.checkbox_music_directors:
                if (checked) {
                    requirementsSelection.add("Music Directors");
                    requirementsSelectionForSms.add("04");
                } else {
                    requirementsSelection.remove("Music Directors");
                    requirementsSelectionForSms.remove("04");
                }
                break;
            case R.id.checkbox_silver_screen_actors_actresses:
                if (checked) {
                    requirementsSelection.add("Silver Screen Actors/Actresses");
                    requirementsSelectionForSms.add("05");
                } else {
                    requirementsSelection.remove("Silver Screen Actors/Actresses");
                    requirementsSelectionForSms.remove("05");
                }
                break;
            case R.id.checkbox_small_screen_actors_actresses:
                if (checked) {
                    requirementsSelection.add("Small Screen Actors/Actresses");
                    requirementsSelectionForSms.add("06");
                } else {
                    requirementsSelection.remove("Small Screen Actors/Actresses");
                    requirementsSelectionForSms.remove("06");
                }
                break;
            case R.id.checkbox_standup_comedians:
                if (checked) {
                    requirementsSelection.add("Stand-Up Comedians");
                    requirementsSelectionForSms.add("07");
                } else {
                    requirementsSelection.remove("Stand-Up Comedians");
                    requirementsSelectionForSms.remove("07");
                }
                break;
            case R.id.checkbox_supporting_actors_actresses:
                if (checked) {
                    requirementsSelection.add("Supporting Actors/Actresses");
                    requirementsSelectionForSms.add("08");
                } else {
                    requirementsSelection.remove("Supporting Actors/Actresses");
                    requirementsSelectionForSms.remove("08");
                }
                break;
            case R.id.checkbox_vj_artists:
                if (checked) {
                    requirementsSelection.add("VJ Artists");
                    requirementsSelectionForSms.add("09");
                } else {
                    requirementsSelection.remove("VJ Artists");
                    requirementsSelectionForSms.remove("09");
                }
                break;
            case R.id.checkbox_vocals:
                if (checked) {
                    requirementsSelection.add("Vocals");
                    requirementsSelectionForSms.add("10");
                } else {
                    requirementsSelection.remove("Vocals");
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
