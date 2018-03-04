package books.effective_java.ch6.item30;

public enum PlanetEnumExample {

    MERCURY(3.302e+23, 2.439e6),
    VENUS(4.869e+24, 6.052e6),
    EARTH(5.975e+24, 6.378e6),
    MARS(6.419e+23, 3.393e6),
    JUPITER(1.899e+27, 7.149e7),
    SATURN(5.685e+26, 6.027e7),
    URANUS(8.8683e+25, 2.556e7),
    NEPTUNE(1.024e+26, 2.477e7);

    private final double mass;      //kg
    private final double radius;    //meter
    private final double surfaceGravity;   // m/s^2

    // Universal gravitational constant in m^3 / kg s^2
    private static final double G = 6.67300E-11;

    PlanetEnumExample(double mass, double radius){
        this.mass = mass;
        this.radius = radius;
        this.surfaceGravity = G * mass / (radius * radius);
    }

    public double getMass(){
        return mass;
    }

    public double getRadius(){
        return radius;
    }

    public double getSurfaceGravity(){
        return surfaceGravity;
    }

    public double getSurfaceWeight(double mass){
        return mass * surfaceGravity;   //F = ma
    }
}
