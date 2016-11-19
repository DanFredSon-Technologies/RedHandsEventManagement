package com.danfredson.redhandseventmanagement;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonAboutUs,
            buttonWeddingPlanning,
            buttonTheInitiatives,
            buttonCelebrityManagement,
            buttonBirthdayParties,
            buttonCorporateEvents,
            buttonInaugurations,
            buttonLifestyleEvents,
            buttonBtlActivities,
            buttonExhibitionStalls,
            buttonPrivateParties,
            buttonBranding,
            buttonSponsorship;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAboutUs = (Button) findViewById(R.id.button_about_us);
        buttonWeddingPlanning = (Button) findViewById(R.id.button_wedding_planning);
        buttonTheInitiatives = (Button) findViewById(R.id.button_the_initiatives);
        buttonCelebrityManagement = (Button) findViewById(R.id.button_celebrity_management);
        buttonSponsorship = (Button) findViewById(R.id.button_sponsorship);
        buttonExhibitionStalls = (Button) findViewById(R.id.button_exhibition_stalls);
        buttonPrivateParties = (Button) findViewById(R.id.button_private_parties);
        buttonLifestyleEvents = (Button) findViewById(R.id.button_lifestyle_events);
        buttonInaugurations = (Button) findViewById(R.id.button_inaugurations);
        buttonCorporateEvents = (Button) findViewById(R.id.button_corporate_events);
        buttonBtlActivities = (Button) findViewById(R.id.button_btl_activities);
        buttonBirthdayParties = (Button) findViewById(R.id.button_birthday_parties);
        buttonBranding = (Button) findViewById(R.id.button_branding);

        buttonAboutUs.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutUs.class);
                startActivity(intent);
            }
        });

        buttonWeddingPlanning.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WeddingPlanning.class);
                startActivity(intent);
            }
        });

        buttonTheInitiatives.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TheInitiatives.class);
                startActivity(intent);
            }
        });

        buttonCelebrityManagement.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CelebrityManagement.class);
                startActivity(intent);
            }
        });

        buttonBirthdayParties.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BirthdayParties.class);
                startActivity(intent);
            }
        });

        buttonCorporateEvents.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CorporateEvents.class);
                startActivity(intent);
            }
        });

        buttonInaugurations.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Inaugurations.class);
                startActivity(intent);
            }
        });

        buttonLifestyleEvents.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LifestyleEvents.class);
                startActivity(intent);
            }
        });

        buttonBtlActivities.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BtlActivities.class);
                startActivity(intent);
            }
        });

        buttonExhibitionStalls.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ExhibitionStalls.class);
                startActivity(intent);
            }
        });

        buttonPrivateParties.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PrivateParties.class);
                startActivity(intent);
            }
        });

        buttonBranding.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Branding.class);
                startActivity(intent);
            }
        });

        buttonSponsorship.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sponsorship.class);
                startActivity(intent);
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
