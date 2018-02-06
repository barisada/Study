package books.effective_java.ch3.item8_9_10;

public class EqualsTest {
    public static void main(String[] args) {
        OverridingEqualHashCodeToString oe1 = new OverridingEqualHashCodeToString("first", 1);
        OverridingEqualHashCodeToString oe2 = new OverridingEqualHashCodeToString("second", 2);
        OverridingEqualHashCodeToString oe3 = new OverridingEqualHashCodeToString("first", 1);


        System.out.println("oe1.equals(oe1) = " + oe1.equals(oe1));
        System.out.println("oe2.equals(oe2) = " + oe2.equals(oe2));
        System.out.println("oe1.equals(oe2) = " + oe1.equals(oe2));
        System.out.println("oe2.equals(oe1) = " + oe2.equals(oe1));
        System.out.println("oe1.equals(oe3) = " + oe1.equals(oe3));
        System.out.println("oe3.equals(oe1) = " + oe3.equals(oe1));
        System.out.println("is oe1 goal ? " + OverridingEqualHashCodeToString.isGoal(oe1));
        System.out.println("is oe2 goal ? " + OverridingEqualHashCodeToString.isGoal(oe2));

        System.out.println("========================");

        OverridingChild oec1 = new OverridingChild("first", 1);
        System.out.println("oe1.equals(oec1) = " + oe1.equals(oec1));
        System.out.println("oec1.equals(oe1) = " + oec1.equals(oe1));
        System.out.println("oec1.equals(oe3) = " + oec1.equals(oe3));
        System.out.println("is oec1 goal ? " + OverridingEqualHashCodeToString.isGoal(oec1));
        System.out.println("oec1 instanceof Overriding = " + (oec1 instanceof OverridingEqualHashCodeToString));
        System.out.println("oe1 instanceof OverridingChild = " + (oe1 instanceof OverridingChild));
    }

}
