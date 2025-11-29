package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OfferSavedActivity extends AppCompatActivity {

    Button button_Compare;
    Button button_EnterAnother;
    Button button_ReturnToMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_saved);

        button_Compare = findViewById((R.id.button_Compare));
        button_EnterAnother = findViewById((R.id.button_EnterAnother));
        button_ReturnToMainMenu = findViewById((R.id.button_ReturnToMainMenu));

        button_Compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OfferSavedActivity.this, CompareTwoJobsActivity.class);
                startActivity(intent);
            }
        });
        button_EnterAnother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OfferSavedActivity.this, JobOfferActivity.class);
                startActivity(intent);
            }
        });
        button_ReturnToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OfferSavedActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}