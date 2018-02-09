package books.effective_java.ch4.item14;

public class AccessorMethodExampleTest {
    public static void main(String[] args) {
        AccessorMethodExample ex = new AccessorMethodExample();
        ex.setA(1);

        System.out.println("ex.thisMayAllow : " + ex.thisMayAllow);
        System.out.println("ex.weirdSum() : " + ex.weirdSum());
        System.out.println("ex.getA() : " + ex.getA());
        System.out.println("ex.getB() : " + ex.getB());

    }
}
