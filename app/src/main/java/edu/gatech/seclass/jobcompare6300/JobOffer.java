package edu.gatech.seclass.jobcompare6300;

import java.io.Serializable;
import java.util.Currency;
import java.util.UUID;

public class JobOffer implements Serializable {
    public UUID Id;
    public String Title;
    public String Company;
    public String City;
    public String State;
    public int CostOfLivingIndex;
    public double YearlySalary;
    public double YearlyBonus;
    public double RetirementBenefits;
    public double RelocationStipend;
    public double RestrictedStockUnitAward;
    public double YearlySalaryAdjustedForCostOfLiving;
    public double YearlyBonusAdjustForCostOfLiving;
    public boolean IsCurrent;
    public double RankingScore;

    //NOT IMPLEMENTED PORPERLY, need further work
    public void AdjustForCostOfLiving()
    {
        YearlySalaryAdjustedForCostOfLiving = YearlySalary;
        YearlyBonusAdjustForCostOfLiving = YearlyBonus;
    }
}
