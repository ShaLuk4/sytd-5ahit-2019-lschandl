package Pumpkin;

public class SimulationFactory implements ISimulationFactory {
    @Override
    public ISimulation createSimulation() {
        return new Drought(new SnailInfestation(new SnailIncidence(new Aridity(new DaylightRatio()))));

    }
}
