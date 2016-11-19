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

public class Branding extends AppCompatActivity {
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
        setContentView(R.layout.activity_branding);

        textViewSelectedRequirements = (TextView) findViewById(R.id.textView_selected_requirements);
        buttonSendRequirements = (Button) findViewById(R.id.button_send_requirements);
        editTextEnterPhoneNumber = (EditText) findViewById(R.id.editText_enter_phone_number);
        editTextEnterMailId = (EditText) findViewById(R.id.editText_enter_mail_id);

        buttonSendRequirements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringPhoneNumber = editTextEnterPhoneNumber.getText().toString();
                stringMailId = editTextEnterMailId.getText().toString();
                stringMessage = "Phn: \n" + stringPhoneNumber + "\nMail: \n" + stringMailId + "\nBr: \n" + stringSelectedRequirementsForSms;
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
            case R.id.checkbox_articles:
                if (checked) {
                    requirementsSelection.add("Articles");
                    requirementsSelectionForSms.add("01");
                } else {
                    requirementsSelection.remove("Articles");
                    requirementsSelectionForSms.remove("01");
                }
                break;
            case R.id.checkbox_auto_back:
                if (checked) {
                    requirementsSelection.add("Auto Back");
                    requirementsSelectionForSms.add("02");
                } else {
                    requirementsSelection.remove("Auto Back");
                    requirementsSelectionForSms.remove("02");
                }
                break;
            case R.id.checkbox_brochures:
                if (checked) {
                    requirementsSelection.add("Brochures");
                    requirementsSelectionForSms.add("03");
                } else {
                    requirementsSelection.remove("Brochures");
                    requirementsSelectionForSms.remove("03");
                }
                break;
            case R.id.checkbox_bus_back:
                if (checked) {
                    requirementsSelection.add("Bus Back");
                    requirementsSelectionForSms.add("04");
                } else {
                    requirementsSelection.remove("Bus Back");
                    requirementsSelectionForSms.remove("04");
                }
                break;
            case R.id.checkbox_catalogs:
                if (checked) {
                    requirementsSelection.add("Catalogs");
                    requirementsSelectionForSms.add("05");
                } else {
                    requirementsSelection.remove("Catalogs");
                    requirementsSelectionForSms.remove("05");
                }
                break;
            case R.id.checkbox_corporate_logo:
                if (checked) {
                    requirementsSelection.add("Corporate Logo");
                    requirementsSelectionForSms.add("06");
                } else {
                    requirementsSelection.remove("Corporate Logo");
                    requirementsSelectionForSms.remove("06");
                }
                break;
            case R.id.checkbox_cutouts_banners:
                if (checked) {
                    requirementsSelection.add("Cutouts/Banners");
                    requirementsSelectionForSms.add("07");
                } else {
                    requirementsSelection.remove("Cutouts/Banners");
                    requirementsSelectionForSms.remove("07");
                }
                break;
            case R.id.checkbox_e_marketing:
                if (checked) {
                    requirementsSelection.add("E-Marketing");
                    requirementsSelectionForSms.add("08");
                } else {
                    requirementsSelection.remove("E-Marketing");
                    requirementsSelectionForSms.remove("08");
                }
                break;
            case R.id.checkbox_flyers_notice_distribution:
                if (checked) {
                    requirementsSelection.add("Flyers/Notice Distribution");
                    requirementsSelectionForSms.add("09");
                } else {
                    requirementsSelection.remove("Flyers/Notice Distribution");
                    requirementsSelectionForSms.remove("09");
                }
                break;
            case R.id.checkbox_newspaper_ads_magazine_ads:
                if (checked) {
                    requirementsSelection.add("Newspaper Ads/Magazine Ads");
                    requirementsSelectionForSms.add("10");
                } else {
                    requirementsSelection.remove("Newspaper Ads/Magazine Ads");
                    requirementsSelectionForSms.remove("10");
                }
                break;
            case R.id.checkbox_newspaper_insertions:
                if (checked) {
                    requirementsSelection.add("Newspaper Insertions");
                    requirementsSelectionForSms.add("11");
                } else {
                    requirementsSelection.remove("Newspaper Insertions");
                    requirementsSelectionForSms.remove("11");
                }
                break;
            case R.id.checkbox_omni_van_promotion:
                if (checked) {
                    requirementsSelection.add("Omni Van Promotion");
                    requirementsSelectionForSms.add("12");
                } else {
                    requirementsSelection.remove("Omni Van Promotion");
                    requirementsSelectionForSms.remove("12");
                }
                break;
            case R.id.checkbox_online_ads:
                if (checked) {
                    requirementsSelection.add("Online Ads");
                    requirementsSelectionForSms.add("13");
                } else {
                    requirementsSelection.remove("Online Ads");
                    requirementsSelectionForSms.remove("13");
                }
                break;
            case R.id.checkbox_posters:
                if (checked) {
                    requirementsSelection.add("Posters");
                    requirementsSelectionForSms.add("14");
                } else {
                    requirementsSelection.remove("Posters");
                    requirementsSelectionForSms.remove("14");
                }
                break;
            case R.id.checkbox_press_release:
                if (checked) {
                    requirementsSelection.add("Press Release");
                    requirementsSelectionForSms.add("15");
                } else {
                    requirementsSelection.remove("Press Release");
                    requirementsSelectionForSms.remove("15");
                }
                break;
            case R.id.checkbox_radio_and_tv_commercials:
                if (checked) {
                    requirementsSelection.add("Radio and TV Commercials");
                    requirementsSelectionForSms.add("16");
                } else {
                    requirementsSelection.remove("Radio and TV Commercials");
                    requirementsSelectionForSms.remove("16");
                }
                break;
            case R.id.checkbox_br_road_shows:
                if (checked) {
                    requirementsSelection.add("Road Shows");
                    requirementsSelectionForSms.add("17");
                } else {
                    requirementsSelection.remove("Road Shows");
                    requirementsSelectionForSms.remove("17");
                }
                break;
            case R.id.checkbox_web_designing:
                if (checked) {
                    requirementsSelection.add("Web Designing");
                    requirementsSelectionForSms.add("18");
                } else {
                    requirementsSelection.remove("Web Designing");
                    requirementsSelectionForSms.remove("18");
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
