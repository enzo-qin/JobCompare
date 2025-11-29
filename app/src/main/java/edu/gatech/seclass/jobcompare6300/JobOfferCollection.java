package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.json.JSONObject;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JobOfferCollection {
    //private ArrayList<JobOffer> _jobOffers = new ArrayList<JobOffer>();
    public double CalculateRankingScore(JobOffer jobOffer, Context context) throws IOException, ClassNotFoundException {
        return new RankingAlgorithm().CalculateRankingScore(jobOffer, context);
    }
    public void AddJobOffer(JobOffer jobOffer, Context context) throws IOException, ClassNotFoundException {
        jobOffer.Id = UUID.randomUUID();
        jobOffer.AdjustForCostOfLiving();
        jobOffer.RankingScore = CalculateRankingScore(jobOffer, context);
        ArrayList<JobOffer> jobOffers = new FileDatabase().ReadAll(context);
        jobOffers.add(jobOffer);
        new FileDatabase().SaveAll(jobOffers, context);
    }
    public void UpdateJobOffer(JobOffer jobOffer, Context context) throws Exception {
        //throw new Exception(String.valueOf(jobOffer.Id));

        ArrayList<JobOffer> jobOffers = new FileDatabase().ReadAll(context);
        JobOffer found = jobOffers.stream().filter(p -> p.IsCurrent).findFirst().orElse(null);
        if(found == null)
        {
            //throw new Exception("Not found");
            jobOffers.add(jobOffer);
        }
        jobOffer.AdjustForCostOfLiving();
        jobOffer.RankingScore = CalculateRankingScore(jobOffer, context);
        jobOffers.remove(found);
        jobOffers.add(jobOffer);
        new FileDatabase().SaveAll(jobOffers, context);


    }
    public void RemoveJobOffer(UUID id, Context context) throws Exception {
        ArrayList<JobOffer> jobOffers = new FileDatabase().ReadAll(context);
        JobOffer found = jobOffers.stream().filter(p -> p.Id == id).findFirst().orElse(null);
        if(found == null)
        {
            throw new Exception("Not found");
        }
        jobOffers.remove(found);
        new FileDatabase().SaveAll(jobOffers, context);
    }
    public ArrayList<JobOffer> DisplayByRanking(Context context) throws IOException, ClassNotFoundException {
        ArrayList<JobOffer> jobOffers = new FileDatabase().ReadAll(context);
        jobOffers.sort((b,a) -> (int)(a.RankingScore - b.RankingScore));
        return jobOffers;
    }
    public void Clear(Context context) throws IOException {
        new FileDatabase().Clear(context);
    }
}
