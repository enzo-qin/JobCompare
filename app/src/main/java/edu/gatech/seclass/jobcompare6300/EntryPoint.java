package edu.gatech.seclass.jobcompare6300;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;

public class EntryPoint {
    public ArrayList<JobOffer> DisplayJobOffersByRanking(Context context) throws IOException, ClassNotFoundException {
        return new JobOfferCollection().DisplayByRanking(context);
    }
    public void AddJobOffer(JobOffer jobOffer, Context context) throws IOException, ClassNotFoundException {
        new JobOfferCollection().AddJobOffer(jobOffer, context);
    }
    public void UpdateJobOffer(JobOffer jobOffer, Context context) throws Exception {
        new JobOfferCollection().UpdateJobOffer(jobOffer, context);
    }
    public void RemoveJobOffer(JobOffer jobOffer, Context context) throws Exception {
        new JobOfferCollection().RemoveJobOffer(jobOffer.Id, context);
    }
    public ComparisonSetting ReadComparisonSetting(Context context) throws IOException, ClassNotFoundException {
        return new FileDatabase().ReadSetting(context);
    }
    public void SaveComparisionSetting(ComparisonSetting comparisonSetting, Context context) throws IOException {
        new FileDatabase().SaveSetting(comparisonSetting,context);
    }

    public JobOffer GetCurrentJobOffer(Context context) throws IOException, ClassNotFoundException {
        ArrayList<JobOffer> ls = DisplayJobOffersByRanking(context);
        for(int i = 0 ;i < ls.stream().count(); i++){
            JobOffer jobOffer = ls.get(i);
            if(jobOffer.IsCurrent){
                return jobOffer;
            }
        }
        JobOffer n = new JobOffer();
        n.IsCurrent = true;
        AddJobOffer(n, context);
        return n;
    }
    public JobOffer EnteredJobOffer = new JobOffer();

    public boolean IsCompareCurrent = true;

    public  ArrayList<JobOffer> ToCompare2 = new ArrayList<>();

    private EntryPoint(){}

    private static final EntryPoint _instance = new EntryPoint();
    public static EntryPoint getInstance(){
        return _instance;
    }

    public void Clear(Context context) throws IOException {
        new FileDatabase().Clear(context);
    }
}
