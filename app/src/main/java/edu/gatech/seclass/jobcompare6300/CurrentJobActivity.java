package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class CurrentJobActivity extends AppCompatActivity {

    TextView textView_Title;
    EditText editText_JobTitle;
    EditText editText_Company;
    EditText editText_City;
    EditText editText_State;
    EditText editText_YearlySalary;
    EditText editText_YearlyBonus;
    EditText editText_RetirementBenefits;
    EditText editText_RelocationStipend;
    EditText editText_RSUA;
    Button button_Cancel;
    Button button_Save;

    private  void ShowToast(String message){
        Context context = getApplicationContext();
        CharSequence text = message;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    private void Init() throws IOException, ClassNotFoundException {
        JobOffer jobOffer = EntryPoint.getInstance().GetCurrentJobOffer(getApplicationContext());

        textView_Title = findViewById((R.id.textView_Title));
        editText_JobTitle = findViewById((R.id.editText_JobTitle));
        editText_Company = findViewById((R.id.editText_Company));
        editText_City = findViewById((R.id.editText_City));
        editText_State = findViewById((R.id.editText_State));
        editText_YearlySalary = findViewById((R.id.editText_YearlySalary));
        editText_YearlyBonus = findViewById((R.id.editText_YearlyBonus));
        editText_RetirementBenefits = findViewById((R.id.editText_RetirementBenefits));
        editText_RelocationStipend = findViewById((R.id.editText_RelocationStipend));
        editText_RSUA = findViewById((R.id.editText_RUSA));

        editText_JobTitle.setText(jobOffer.Title);
        editText_Company.setText(jobOffer.Company);
        editText_City.setText(jobOffer.City);
        editText_State.setText(jobOffer.State);
        editText_YearlySalary.setText(String.valueOf(jobOffer.YearlySalary));
        editText_YearlyBonus.setText(String.valueOf(jobOffer.YearlyBonus));
        editText_RetirementBenefits.setText(String.valueOf(jobOffer.RetirementBenefits));
        editText_RelocationStipend.setText(String.valueOf(jobOffer.RelocationStipend));
        editText_RSUA.setText(String.valueOf(jobOffer.RestrictedStockUnitAward));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_job);

        try {
            Init();
        }catch (Exception ex){
            ShowToast(ex.getMessage());
        }

        textView_Title = findViewById((R.id.textView_Title));
        editText_JobTitle = findViewById((R.id.editText_JobTitle));
        editText_Company = findViewById((R.id.editText_Company));
        editText_City = findViewById((R.id.editText_City));
        editText_State = findViewById((R.id.editText_State));
        editText_YearlySalary = findViewById((R.id.editText_YearlySalary));
        editText_YearlyBonus = findViewById((R.id.editText_YearlyBonus));
        editText_RetirementBenefits = findViewById((R.id.editText_RetirementBenefits));
        editText_RelocationStipend = findViewById((R.id.editText_RelocationStipend));
        editText_RSUA = findViewById((R.id.editText_RUSA));
        button_Cancel = findViewById((R.id.button_MainMenu));
        button_Save = findViewById((R.id.button_CompareTwo));



//        String title2 = getIntent().getStringExtra("key");
//        textView_Title.setText(title2);

        button_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // please add pop up msg says data not saved

                Intent intent = new Intent(CurrentJobActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // please put code here to save the date entered to database

                // And pop up a message to user says data saved

                // return to the main menu

                try {


                    JobOffer jobOffer = EntryPoint.getInstance().GetCurrentJobOffer(getApplicationContext());
                    jobOffer.Title = editText_JobTitle.getText().toString();
                    jobOffer.Company = editText_Company.getText().toString();
                    jobOffer.City = editText_City.getText().toString();
                    jobOffer.State = editText_State.getText().toString();
                    if(!editText_YearlySalary.getText().toString().isEmpty()){
                        jobOffer.YearlySalary = Double.parseDouble(editText_YearlySalary.getText().toString());
                    }
                    if(!editText_YearlySalary.getText().toString().isEmpty()){
                        jobOffer.YearlySalary = Double.parseDouble(editText_YearlySalary.getText().toString());
                    }
                    if(!editText_YearlyBonus.getText().toString().isEmpty()){
                        jobOffer.YearlyBonus = Double.parseDouble(editText_YearlyBonus.getText().toString());
                    }
                    if(!editText_RetirementBenefits.getText().toString().isEmpty()){
                        jobOffer.RetirementBenefits = Double.parseDouble(editText_RetirementBenefits.getText().toString());
                    }
                    if(!editText_RelocationStipend.getText().toString().isEmpty()){
                        jobOffer.RelocationStipend = Double.parseDouble(editText_RelocationStipend.getText().toString());
                    }
                    if(!editText_RSUA.getText().toString().isEmpty()){
                        jobOffer.RestrictedStockUnitAward = Double.parseDouble(editText_RSUA.getText().toString());
                    }

                    EntryPoint.getInstance().UpdateJobOffer(jobOffer, getApplicationContext());

                    ShowToast("Offer Saved");
                }catch (Exception ex){
                    ShowToast(ex.getMessage());
                }

                Intent intent = new Intent(CurrentJobActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}