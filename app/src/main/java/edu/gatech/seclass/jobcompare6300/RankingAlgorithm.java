package edu.gatech.seclass.jobcompare6300;

import android.content.Context;

import java.io.IOException;

public class RankingAlgorithm {
    public double CalculateRankingScore(JobOffer jobOffer, Context context) throws IOException, ClassNotFoundException {
        ComparisonSetting comparisonSetting = new FileDatabase().ReadSetting(context);
        int total = comparisonSetting.WeightOfRelocationStipend
                + comparisonSetting.WeightOfRestrictedStockUnitAward
                + comparisonSetting.WeightOfRetirementBenefits
                + comparisonSetting.WeightOfYearlyBonus
                + comparisonSetting.WeightOfYearlySalary;

        double result = jobOffer.YearlySalaryAdjustedForCostOfLiving * comparisonSetting.WeightOfYearlySalary / total
                + jobOffer.YearlyBonusAdjustForCostOfLiving * comparisonSetting.WeightOfYearlyBonus / total
                + jobOffer.RelocationStipend + comparisonSetting.WeightOfRelocationStipend / total
                + (jobOffer.RetirementBenefits * jobOffer.YearlySalaryAdjustedForCostOfLiving/100) * comparisonSetting.WeightOfRetirementBenefits / total
                + (jobOffer.RestrictedStockUnitAward/4) * comparisonSetting.WeightOfRestrictedStockUnitAward / total;

        return result;
    }
}
