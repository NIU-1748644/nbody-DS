package solution;

public class NBodySimulator {

    private double timeStep;
    private int pauseTime;
    private boolean trace;
    private Universe universe;

    public NBodySimulator(Universe universe, double dt, int pt, boolean doTrace) {
        this.universe = universe;
        timeStep = dt;
        pauseTime = pt;
        trace = doTrace;
    }

    public void simulate() {
        createCanvas();
        while (true) {
            if (trace) {
                StdDraw.setPenColor(StdDraw.WHITE);
                drawUniverse();
                universe.update(timeStep);
                StdDraw.setPenColor(StdDraw.BLACK);
            } else {
                StdDraw.clear();
                universe.update(timeStep);
            }
            drawUniverse();
            StdDraw.show();
            StdDraw.pause(pauseTime);
        }
    }

    private void createCanvas() {
        if (trace) {
            StdDraw.clear(StdDraw.GRAY);
        }
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenRadius(0.025);
        double radius = universe.getRadius();
        StdDraw.setXscale(-radius, +radius);
        StdDraw.setYscale(-radius, +radius);
    }

    private void drawUniverse() {
        int n = universe.getNumBodies();
        for (int i = 0; i < n; i++) {
            Vector pos = universe.getBodyPosition(i);
            StdDraw.point(pos.cartesian(0), pos.cartesian(1));
        }
    }
}
