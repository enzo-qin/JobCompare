package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    EditText editText_YearlySalary;
    EditText editText_YearlyBonus;
    EditText editText_RetirementBenefits;
    EditText editText_RelocationStipend;
    EditText editText_RUSA;
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
        setContentView(R.layout.activity_setting);

        editText_YearlySalary = findViewById(R.id.editText_YearlySalary);
        editText_YearlyBonus = findViewById(R.id.editText_YearlyBonus);
        editText_RetirementBenefits = findViewById(R.id.editText_RetirementBenefits);
        editText_RelocationStipend = findViewById(R.id.editText_RelocationStipend);
        editText_RUSA = findViewById(R.id.editText_RUSA);

        button_Cancel = findViewById((R.id.button_MainMenu));
        button_Save = findViewById((R.id.button_CompareTwo));

        try {
            ComparisonSetting comparisonSetting = EntryPoint.getInstance().ReadComparisonSetting(getApplicationContext());
            editText_YearlySalary.setText(Integer.toString(comparisonSetting.WeightOfYearlySalary));
            editText_YearlyBonus.setText(Integer.toString(comparisonSetting.WeightOfYearlyBonus));

            editText_RetirementBenefits.setText(Integer.toString(comparisonSetting.WeightOfRetirementBenefits));
            editText_RelocationStipend.setText(Integer.toString(comparisonSetting.WeightOfRelocationStipend));
            editText_RUSA.setText(Integer.toString(comparisonSetting.WeightOfRestrictedStockUnitAward));

        }catch (Exception ex){
            ShowToast(ex.getMessage());
        }

        button_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // pop up msg says data not saved
                ShowToast("Not Saved");

                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // please put code here to save the date entered to database

                // pop up msg says data saved

                ComparisonSetting comparisonSetting = new ComparisonSetting();

                if(!editText_YearlySalary.getText().toString().isEmpty()){
                    comparisonSetting.WeightOfYearlySalary = Integer.parseInt(editText_YearlySalary.getText().toString());
                }
                if(!editText_YearlyBonus.getText().toString().isEmpty()){
                    comparisonSetting.WeightOfYearlyBonus = Integer.parseInt(editText_YearlyBonus.getText().toString());
                }
                if(!editText_RetirementBenefits.getText().toString().isEmpty()){
                    comparisonSetting.WeightOfRetirementBenefits = Integer.parseInt(editText_RetirementBenefits.getText().toString());
                }
                if(!editText_RelocationStipend.getText().toString().isEmpty()){
                    comparisonSetting.WeightOfRelocationStipend = Integer.parseInt(editText_RelocationStipend.getText().toString());
                }
                if(!editText_RUSA.getText().toString().isEmpty()){
                    comparisonSetting.WeightOfRestrictedStockUnitAward= Integer.parseInt(editText_RUSA.getText().toString());
                }
                try {
                    EntryPoint.getInstance().SaveComparisionSetting(comparisonSetting, getApplicationContext());
                }catch (Exception ex){
                    ShowToast(ex.getMessage());
                }

                ShowToast("Comparison Settings Saved");


                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}