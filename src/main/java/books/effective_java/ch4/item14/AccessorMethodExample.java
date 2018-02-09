package books.effective_java.ch4.item14;

import java.util.Random;

public class AccessorMethodExample {
    private int a;
    private int b;
    public final int thisMayAllow;
    private InnerClassDontNeedAccessorMethod noAccessorMethod;

    public AccessorMethodExample(){
        thisMayAllow = new Random().nextInt();
        noAccessorMethod = new InnerClassDontNeedAccessorMethod();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int weirdSum(){
        return a + noAccessorMethod.a;
    }

    private class InnerClassDontNeedAccessorMethod{
        public int a = new Random().nextInt();
    }
}
