package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;

public class CompareTwoJobsActivity extends AppCompatActivity {

    Button button_MainMenu;
    Button button_NewComparison;

    private  void ShowToast(String message){
        Context context = getApplicationContext();
        CharSequence text = message;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void Init() throws IOException, ClassNotFoundException {
        TextView job1_title = findViewById(R.id.jt1);
        TextView job2_title = findViewById(R.id.jt2);
        TextView job1_company = findViewById(R.id.c1);
        TextView job1_location = findViewById(R.id.l1);
        TextView job2_location = findViewById(R.id.l2);
        TextView job2_company = findViewById(R.id.c2);
        TextView job1_salary = findViewById(R.id.ys1);
        TextView job2_salary = findViewById(R.id.ys2);
        TextView job1_bonus = findViewById(R.id.yb1);
        TextView job2_bonus = findViewById(R.id.yb2);
        TextView job1_benifit = findViewById(R.id.rb1);
        TextView job2_benifit = findViewById(R.id.rb2);
        TextView job1_stipend = findViewById(R.id.rs1);
        TextView job2_stipend = findViewById(R.id.rs2);
        TextView job1_stock = findViewById(R.id.rsua1);
        TextView job2_stock = findViewById(R.id.rsua2);




        JobOffer job1;
        JobOffer job2;
        if(EntryPoint.getInstance().IsCompareCurrent) {
            ShowToast("Comapre current");
            job1 = EntryPoint.getInstance().GetCurrentJobOffer(getApplicationContext());
            job2 = EntryPoint.getInstance().EnteredJobOffer;
        }else{
            ShowToast("Compare selected");
            if(EntryPoint.getInstance().ToCompare2.stream().count() > 0){
                job1 = EntryPoint.getInstance().ToCompare2.get(0);
            }
            else{
                job1 = new JobOffer();
            }
            if(EntryPoint.getInstance().ToCompare2.stream().count() > 1){
                job2 = EntryPoint.getInstance().ToCompare2.get(1);
            }else{
                job2 = new JobOffer();
            }
        }

        job1_title.setText(job1.Title);
        job2_title.setText(job2.Title);

        job1_company.setText(job1.Company);
        job2_company.setText(job2.Company);

        job1_location.setText(job1.City + ", " + job1.State);
        job2_location.setText(job2.City + ", " + job2.State);

        job1_salary.setText(String.valueOf(job1.YearlySalary));
        job2_salary.setText(String.valueOf(job2.YearlySalary));

        job1_bonus.setText(String.valueOf(job1.YearlyBonus));
        job2_bonus.setText(String.valueOf(job2.YearlyBonus));

        job1_benifit.setText(String.valueOf(job1.RetirementBenefits));
        job2_benifit.setText(String.valueOf(job2.RetirementBenefits));

        job1_stipend.setText(String.valueOf(job1.RelocationStipend));
        job2_stipend.setText(String.valueOf(job2.RelocationStipend));

        job1_stock.setText(String.valueOf(job1.RestrictedStockUnitAward));
        job2_stock.setText(String.valueOf(job2.RestrictedStockUnitAward));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_two_jobs);

        try {
            Init();
        }catch (Exception ex){
            ShowToast(ex.getMessage());
        }


        button_MainMenu = findViewById((R.id.button_MainMenu));
        button_NewComparison = findViewById((R.id.button_CompareTwo));

        button_MainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CompareTwoJobsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button_NewComparison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CompareTwoJobsActivity.this, JobOfferListActivity.class);
                startActivity(intent);
            }
        });

    }
}