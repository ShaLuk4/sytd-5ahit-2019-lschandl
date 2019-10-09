package Pumpkin;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SnailInfestation implements ISimulation{

    @NonNull
    private ISimulation simulation;

    @Override
    public GrowRate calculateGrowthRatio(Records<Environment> daylightRatioList, Environment record) {
        GrowRate growthRateRecord = simulation.calculateGrowthRatio(daylightRatioList, record);

        List<Environment> subRecordList = daylightRatioList.precedingRecordSublist(record, 2);

        if(subRecordList.size() == 2){
            int rainAmountInLast2Days = subRecordList.stream().map(Environment::getRainRatio).reduce(0, (a, b) -> a+b);

            if(rainAmountInLast2Days >= 30){
                growthRateRecord.setGrowthRate(growthRateRecord.getGrowthRate() - 1);
                growthRateRecord.addEffectDescription(getDescription());
            }
        }

        return growthRateRecord;
    }

    @Override
    public String getDescription() {
        return "Effect 5: Snail Infestation";
    }

}
