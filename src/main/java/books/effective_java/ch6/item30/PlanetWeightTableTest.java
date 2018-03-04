package books.effective_java.ch6.item30;

public class PlanetWeightTableTest {
    public static void main(String[] args) {
        double earthWeight = 175;
        double mass = earthWeight / PlanetEnumExample.EARTH.getSurfaceGravity();

        for(PlanetEnumExample ex : PlanetEnumExample.values()){
            System.out.printf("Weight on %s is %f%n", ex, ex.getSurfaceWeight(mass));
        }
    }
}
