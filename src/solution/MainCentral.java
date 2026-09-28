package solution;

public class MainCentral {
    public static void main(String[] args) {
        double dt = Double.parseDouble(args[0]);
        int pauseTime = Integer.parseInt(args[1]);
        boolean trace = args[2].toLowerCase().equals("trace");

        Universe universe = UniverseFactory.makeCentralConfiguration(6, Math.PI / 2);
        NBodySimulator simulator = new NBodySimulator(universe, dt, pauseTime, trace);
        simulator.simulate();
    }
}
