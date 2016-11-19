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

public class BirthdayParties extends AppCompatActivity {
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
        setContentView(R.layout.activity_birthday_parties);

        textViewSelectedRequirements = (TextView) findViewById(R.id.textView_selected_requirements);
        buttonSendRequirements = (Button) findViewById(R.id.button_send_requirements);
        editTextEnterPhoneNumber = (EditText) findViewById(R.id.editText_enter_phone_number);
        editTextEnterMailId = (EditText) findViewById(R.id.editText_enter_mail_id);

        buttonSendRequirements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPhoneNumber = editTextEnterPhoneNumber.getText().toString();
                stringMailId = editTextEnterMailId.getText().toString();
                stringMessage = "Phn: \n" + stringPhoneNumber + "\nMail: \n" + stringMailId + "\nBP: \n" + stringSelectedRequirementsForSms;
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
            case R.id.checkbox_birthday_candles_caps_props:
                if (checked) {
                    requirementsSelection.add("Birthday Candles, Caps, Props");
                    requirementsSelectionForSms.add("01");
                } else {
                    requirementsSelection.remove("Birthday Candles, Caps, Props");
                    requirementsSelectionForSms.remove("01");
                }
                break;
            case R.id.checkbox_bouncing_castle_and_stall_games:
                if (checked) {
                    requirementsSelection.add("Bouncing Castle and Stall Games");
                    requirementsSelectionForSms.add("02");
                } else {
                    requirementsSelection.remove("Bouncing Castle and Stall Games");
                    requirementsSelectionForSms.remove("02");
                }
                break;
            case R.id.checkbox_cartoon_characters:
                if (checked) {
                    requirementsSelection.add("Cartoon Characters");
                    requirementsSelectionForSms.add("03");
                } else {
                    requirementsSelection.remove("Cartoon Characters");
                    requirementsSelectionForSms.remove("03");
                }
                break;
            case R.id.checkbox_emcee:
                if (checked) {
                    requirementsSelection.add("Emcee");
                    requirementsSelectionForSms.add("04");
                } else {
                    requirementsSelection.remove("Emcee");
                    requirementsSelectionForSms.remove("04");
                }
                break;
            case R.id.checkbox_kids_entertainment:
                if (checked) {
                    requirementsSelection.add("Kids Entertainment");
                    requirementsSelectionForSms.add("05");
                } else {
                    requirementsSelection.remove("Kids Entertainment");
                    requirementsSelectionForSms.remove("05");
                }
                break;
            case R.id.checkbox_magicians:
                if (checked) {
                    requirementsSelection.add("Magicians");
                    requirementsSelectionForSms.add("06");
                } else {
                    requirementsSelection.remove("Magicians");
                    requirementsSelectionForSms.remove("06");
                }
                break;
            case R.id.checkbox_popcorns_and_cotton_candy:
                if (checked) {
                    requirementsSelection.add("Popcorns and Cotton Candy");
                    requirementsSelectionForSms.add("07");
                } else {
                    requirementsSelection.remove("Popcorns and Cotton Candy");
                    requirementsSelectionForSms.remove("07");
                }
                break;
            case R.id.checkbox_stilt_walkers:
                if (checked) {
                    requirementsSelection.add("Stilt Walkers");
                    requirementsSelectionForSms.add("08");
                } else {
                    requirementsSelection.remove("Stilt Walkers");
                    requirementsSelectionForSms.remove("08");
                }
                break;
            case R.id.checkbox_tattoo_and_face_painters:
                if (checked) {
                    requirementsSelection.add("Tattoo and Face Painters");
                    requirementsSelectionForSms.add("09");
                } else {
                    requirementsSelection.remove("Tattoo and Face Painters");
                    requirementsSelectionForSms.remove("09");
                }
                break;
            case R.id.checkbox_themes_parties:
                if (checked) {
                    requirementsSelection.add("Themes Parties");
                    requirementsSelectionForSms.add("10");
                } else {
                    requirementsSelection.remove("Themes Parties");
                    requirementsSelectionForSms.remove("10");
                }
                break;
            case R.id.checkbox_venue_decorations:
                if (checked) {
                    requirementsSelection.add("Venue Decoration");
                    requirementsSelectionForSms.add("11");
                } else {
                    requirementsSelection.remove("Venue Decoration");
                    requirementsSelectionForSms.remove("11");
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
