package Pumpkin;

import java.util.ArrayList;
import java.util.List;

public class GrowSimulator {
    private Records<Environment> inputData = new Records<>();

    private List<GrowRate> growthRateData = new ArrayList<>();

    private ISimulation simulation;

    public GrowSimulator() {
        simulation = new SimulationFactory().createSimulation();
    }

    public void init() {
        inputData = new Records<>();
        growthRateData = new ArrayList<>();
    }

    public void addInputRecord(int lightRatio) {
        inputData.add(new Environment(lightRatio));
    }

    public void runSimulation() {
        analyzeData();
        simulateOutcome();
    }

    private void analyzeData() {
        inputData.forEach((Environment record) -> {
            growthRateData.add(this.simulation.calculateGrowthRatio(inputData, record));
        });
    }

    private void simulateOutcome() {
        growthRateData.forEach((GrowRate record) -> System.out.println(record.toString()));
    }

}
