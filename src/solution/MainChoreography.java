package solution;

public class MainChoreography {
    public static void main(String[] args) {
        double dt = Double.parseDouble(args[0]);
        int pauseTime = Integer.parseInt(args[1]);
        boolean trace = args[2].toLowerCase().equals("trace");
        int nchoreography = args.length > 3 ? Integer.parseInt(args[3]) : 2;

        Universe universe = UniverseFactory.makeChoreography(nchoreography);
        NBodySimulator simulator = new NBodySimulator(universe, dt, pauseTime, trace);
        simulator.simulate();
    }
}
