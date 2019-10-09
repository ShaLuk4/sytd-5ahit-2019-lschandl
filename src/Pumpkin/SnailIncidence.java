package Pumpkin;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SnailIncidence implements ISimulation {

    @NonNull
    private ISimulation simulation;

    @Override
    public GrowRate calculateGrowthRatio(Records<Environment> daylightRatioList, Environment record) {
        GrowRate growthRateRecord = simulation.calculateGrowthRatio(daylightRatioList, record);

        if (record.getRainRatio() >= 50) {
            growthRateRecord.setGrowthRate(growthRateRecord.getGrowthRate() - 1);
            growthRateRecord.addEffectDescription(getDescription());
        }

        return growthRateRecord;
    }

    @Override
    public String getDescription() {
        return "Effect 4: Snail incidence";
    }
}
