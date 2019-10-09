package Pumpkin;



public class DaylightRatio implements ISimulation {

    @Override
    public GrowRate calculateGrowthRatio(Records<Environment> daylightRatioList, Environment record) {
        GrowRate growthRecord = new GrowRate(new Integer(calculateGrowthRation(record.getDaylightRatio())));
        growthRecord.addEffectDescription(getDescription());

        return growthRecord;
    }

    @Override
    public String getDescription() {
        return "Effect 1: light influence on pumkin growth";
    }

    private int calculateGrowthRation(int daylightRatio){
        if(0 <= daylightRatio  && daylightRatio <= 19){
            return 0;
        }

        if(20 <= daylightRatio  && daylightRatio <= 39){
            return 1;
        }

        if(40 <= daylightRatio  && daylightRatio <= 59){
            return 2;
        }

        if(60 <= daylightRatio  && daylightRatio <= 79){
            return 3;
        }

        if(80 <= daylightRatio  && daylightRatio <= 99){
            return 4;
        }

        return 5;
    }

}
