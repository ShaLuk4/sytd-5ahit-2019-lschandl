package Pumpkin;

public interface ISimulation {
    GrowRate calculateGrowthRatio(Records<Environment> daylightRatioList, Environment record);

    String getDescription();
}
