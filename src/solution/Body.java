package solution;

public class Body {
    private Vector r;
    private Vector v;
    private final double mass;
    private final double G;

    public Body(Vector r, Vector v, double mass) {
        this(r, v, mass, 6.67e-11);
    }

    public Body(Vector r, Vector v, double mass, double G) {
        this.r = r;
        this.v = v;
        this.mass = mass;
        this.G = G;
    }

    public void move(Vector f, double dt) {
        Vector a = f.scale(1 / mass);
        v = v.plus(a.scale(dt));
        r = r.plus(v.scale(dt));
    }

    public Vector forceFrom(Body b) {
        Vector delta = b.r.minus(r);
        double dist = delta.magnitude();
        double magnitude = (G * mass * b.mass) / (dist * dist);
        return delta.direction().scale(magnitude);
    }

    public Vector getPosition() {
        return r;
    }

    public String toString() {
        return "position " + r + ", velocity " + v + ", mass " + mass;
    }
}
