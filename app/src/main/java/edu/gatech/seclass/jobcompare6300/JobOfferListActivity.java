package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class JobOfferListActivity extends AppCompatActivity {
    Button button_MainMenu;
    Button button_NewComparison;
    private  void ShowToast(String message){
        Context context = getApplicationContext();
        CharSequence text = message;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    private void Init(){
        TableLayout table1 = (TableLayout) findViewById(R.id.tableLayout1);

        TableRow rowh = new TableRow(this);
        TextView scoreh = new TextView(this);
        scoreh.setTextSize(20);
        scoreh.setTextColor(Color.BLUE);
        scoreh.setText("Score");
        scoreh.setWidth(300);
        rowh.addView(scoreh);
        TextView titleh = new TextView(this);
        titleh.setText("Title");
        titleh.setTextSize(20);
        titleh.setTextColor(Color.BLUE);
        titleh.setWidth(400);
        rowh.addView(titleh);
        TextView companyh = new TextView(this);
        companyh.setText("Company");
        companyh.setTextColor(Color.BLUE);
        companyh.setTextSize(20);
        companyh.setWidth(400);
        rowh.addView(companyh);
        TextView isSelctedh = new TextView(this);
        isSelctedh.setText("Selected?");
        isSelctedh.setTextSize(20);
        isSelctedh.setTextColor(Color.RED);
        rowh.addView(isSelctedh);
        table1.addView(rowh);

        try {
            ArrayList<JobOffer> jobOffers = EntryPoint.getInstance().DisplayJobOffersByRanking(getApplicationContext());
            for(int i = 0 ; i < jobOffers.stream().count(); i++){
                JobOffer jobOffer = jobOffers.get(i);

                TableRow row = new TableRow(this);
                TextView score = new TextView(this);
                score.setTextSize(18);
                score.setText(String.valueOf(jobOffer.RankingScore).substring(0,3));
                row.addView(score);
                TextView title = new TextView(this);
                title.setText(jobOffer.Title);
                title.setWidth(200);
                title.setTextSize(18);
                row.addView(title);
                TextView company = new TextView(this);
                company.setText(jobOffer.Company);
                company.setTextSize(18);
                company.setWidth(300);
                row.addView(company);
                CheckBox checkBox = new CheckBox(this);
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b){
                            EntryPoint.getInstance().ToCompare2.add(jobOffer);
                        }else{
                            EntryPoint.getInstance().ToCompare2.remove(jobOffer);
                        }
                    }
                });
                row.addView(checkBox);

                if(jobOffer.IsCurrent){
                    row.setBackgroundColor(Color.GRAY);
                }

                table1.addView(row);
            }
            EntryPoint.getInstance().ToCompare2.clear();
        }catch (Exception ex){

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_offer_list);

        Init();

        button_MainMenu = findViewById((R.id.button_MainMenu));
        button_NewComparison = findViewById((R.id.button_CompareTwo));

        button_MainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JobOfferListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button_NewComparison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EntryPoint.getInstance().IsCompareCurrent = false;

                Intent intent = new Intent(JobOfferListActivity.this, CompareTwoJobsActivity.class);
                startActivity(intent);
            }
        });
    }
}