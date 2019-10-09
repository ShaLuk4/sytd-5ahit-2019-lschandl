package Pumpkin;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Drought implements ISimulation{

    @NonNull
    private ISimulation simulation;

    @Override
    public GrowRate calculateGrowthRatio(Records<Environment> daylightRatioList, Environment record) {
        GrowRate growthRateRecord = simulation.calculateGrowthRatio(daylightRatioList, record);
        int growthAmount = growthRateRecord.getGrowthRate();

        List<Environment> subRecordList = daylightRatioList.precedingRecordSublist(record, 10);

        if(subRecordList.size() == 10){
            int rainAmountInLast10Days = subRecordList.stream().map(Environment::getRainRatio).reduce(0, (a, b) -> a+b);

            if(rainAmountInLast10Days < 10){
                growthAmount = 0;

                growthRateRecord.setGrowthRate(growthAmount);
                growthRateRecord.addEffectDescription(getDescription());
            }
        }

        return growthRateRecord;
    }

    @Override
    public String getDescription() {
        return "Effect 3: Growth halted for drought period";
    }
}
