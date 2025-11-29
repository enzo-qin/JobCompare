package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class JobOfferActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_offer);

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



        button_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // please add pop up msg says data not saved

                ShowToast("Data not saved");
                Intent intent = new Intent(JobOfferActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // please put code here to save the date entered to database
                try {
                    JobOffer jobOffer = new JobOffer();
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
                    jobOffer.IsCurrent = false;
                    EntryPoint.getInstance().EnteredJobOffer = jobOffer;
                    EntryPoint.getInstance().IsCompareCurrent = true;

                    EntryPoint.getInstance().AddJobOffer(jobOffer, getApplicationContext());

                    ShowToast("Offer Saved");
                }catch (Exception ex){
                    ShowToast(ex.getMessage());
                }


                Intent intent = new Intent(JobOfferActivity.this, OfferSavedActivity.class);
                startActivity(intent);
            }
        });
    }
}