package Pumpkin;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Aridity implements ISimulation {

    @NonNull
    private ISimulation simulation;

    @Override
    public GrowRate calculateGrowthRatio(Records<Environment> daylightRatioList, Environment record) {
        GrowRate growthRecord = simulation.calculateGrowthRatio(daylightRatioList, record);
        int growthAmount = growthRecord.getGrowthRate();

        List<Environment> subRecordList = daylightRatioList.precedingRecordSublist(record, 5);

        if(subRecordList.size() == 5){
            int rainAmountInLast5Days = subRecordList.stream().map(Environment::getRainRatio).reduce(0, (a, b) -> a+b);

            if(rainAmountInLast5Days < 10){
                growthAmount /= 2;

                growthRecord.setGrowthRate(growthAmount);
                growthRecord.addEffectDescription(getDescription());
            }
        }

        return growthRecord;
    }

    @Override
    public String getDescription() {
        return "Effect 2: Little rain in last 5 days";
    }

}
