package books.effective_java.ch4.item20;

public class HierachyTest {
    public static void main(String[] args) {
        HierarchyClassExample ex = new HierarchyClassExample();
        HierarchyClassExample.Figure circle = ex.getCircle(1);
        HierarchyClassExample.Figure rectangle = ex.getRectagle(2,3);
        HierarchyClassExample.Figure square = ex.getSquare(4);

        System.out.println("circle area : " + circle.area());
        System.out.println("rectangle area : " + rectangle.area());
        System.out.println("square area : " + square.area());

    }
}
