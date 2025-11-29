package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button_EnterOrEditCurrentJob;
    Button button_EnterJobOffer;
    Button button_Setting;
    Button button_CompareJobOffers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_EnterOrEditCurrentJob = findViewById((R.id.button_EnterOrEditCurrentJob));
        button_EnterJobOffer = findViewById((R.id.button_EnterJobOffer));
        button_Setting = findViewById((R.id.button_Setting));
        button_CompareJobOffers = findViewById((R.id.button_CompareJobOffers));

        // if there is a current job, all details of the current job will show up;
        // if there is no current job, all details will be empty, filled with hints;
        button_EnterOrEditCurrentJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CurrentJobActivity.class);
//                String title = "Current Job";
//                intent.putExtra("key", title);
                startActivity(intent);
            }
        });

        // when user click on this option, 'EditJob' page will show up with title 'New Job Offer'
        button_EnterJobOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, JobOfferActivity.class);
//                String title = "New Job Offer";
//                intent.putExtra("key", title);
                startActivity(intent);
            }
        });

        button_Setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        button_CompareJobOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, JobOfferListActivity.class);
                startActivity(intent);
            }
        });
    }
}