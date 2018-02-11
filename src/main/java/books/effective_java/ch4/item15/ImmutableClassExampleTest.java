package books.effective_java.ch4.item15;

public class ImmutableClassExampleTest {

    public static void main(String[] args) {
        ImmutableClassExample ex1 = ImmutableClassExample.valueOf(1,1);
        ImmutableClassExample ex2 = ImmutableClassExample.valueOf(2,2);

        ImmutableClassExample add = ex1.add(ex2);
        ImmutableClassExample sub = ex1.subtract(ex2);
        System.out.println("add : " + add);
        System.out.println("sub : " + sub);
    }
}
