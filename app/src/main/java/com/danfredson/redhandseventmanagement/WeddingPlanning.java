package com.danfredson.redhandseventmanagement;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WeddingPlanning extends AppCompatActivity {
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
        setContentView(R.layout.activity_wedding_planning);

        textViewSelectedRequirements = (TextView) findViewById(R.id.textView_selected_requirements);
        buttonSendRequirements = (Button) findViewById(R.id.button_send_requirements);
        editTextEnterPhoneNumber = (EditText) findViewById(R.id.editText_enter_phone_number);
        editTextEnterMailId = (EditText) findViewById(R.id.editText_enter_mail_id);

        buttonSendRequirements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPhoneNumber = editTextEnterPhoneNumber.getText().toString();
                stringMailId = editTextEnterMailId.getText().toString();
                stringMessage = "Phn: \n" + stringPhoneNumber + "\nMail: \n" + stringMailId + "\nWP: \n" + stringSelectedRequirementsForSms;
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
            case R.id.checkbox_invitation_cards:
                if (checked) {
                    requirementsSelection.add("Invitation Cards");
                    requirementsSelectionForSms.add("01");
                } else {
                    requirementsSelection.remove("Invitation Cards");
                    requirementsSelectionForSms.remove("01");
                }
                break;
            case R.id.checkbox_decoration:
                if (checked) {
                    requirementsSelection.add("Decoration");
                    requirementsSelectionForSms.add("02");
                } else {
                    requirementsSelection.remove("Decoration");
                    requirementsSelectionForSms.remove("02");
                }
                break;
            case R.id.checkbox_car:
                if (checked) {
                    requirementsSelection.add("Car");
                    requirementsSelectionForSms.add("03");
                } else {
                    requirementsSelection.remove("Car");
                    requirementsSelectionForSms.remove("03");
                }
                break;
            case R.id.checkbox_guest_management:
                if (checked) {
                    requirementsSelection.add("Guest Management");
                    requirementsSelectionForSms.add("04");
                } else {
                    requirementsSelection.remove("Guest Management");
                    requirementsSelectionForSms.remove("04");
                }
                break;
            case R.id.checkbox_floral:
                if (checked) {
                    requirementsSelection.add("Floral");
                    requirementsSelectionForSms.add("05");
                } else {
                    requirementsSelection.remove("Floral");
                    requirementsSelectionForSms.remove("05");
                }
                break;
            case R.id.checkbox_stage_and_venue:
                if (checked) {
                    requirementsSelection.add("Stage and Venue");
                    requirementsSelectionForSms.add("06");
                } else {
                    requirementsSelection.remove("Stage and Venue");
                    requirementsSelectionForSms.remove("06");
                }
                break;
            case R.id.checkbox_mehanadi_artist:
                if (checked) {
                    requirementsSelection.add("Mehanadi Artist");
                    requirementsSelectionForSms.add("07");
                } else {
                    requirementsSelection.remove("Mehanadi Artist");
                    requirementsSelectionForSms.remove("07");
                }
                break;
            case R.id.checkbox_photographer_and_videographer:
                if (checked) {
                    requirementsSelection.add("Photographer and Videographer");
                    requirementsSelectionForSms.add("08");
                } else {
                    requirementsSelection.remove("Photographer and Videographer");
                    requirementsSelectionForSms.remove("08");
                }
                break;
            case R.id.checkbox_sound_and_lighting:
                if (checked) {
                    requirementsSelection.add("Sound and Lighting");
                    requirementsSelectionForSms.add("09");
                } else {
                    requirementsSelection.remove("Sound and Lighting");
                    requirementsSelectionForSms.remove("09");
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
