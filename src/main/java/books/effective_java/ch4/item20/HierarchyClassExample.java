package books.effective_java.ch4.item20;

public class HierarchyClassExample {
    abstract class Figure{
        abstract double area();
    }

    class Circle extends Figure{
        final double radius;
        Circle(double radius){
            this.radius = radius;
        }

        @Override
        double area() {
            return Math.PI * (radius * radius);
        }
    }

    class Rectangle extends Figure{
        final double length;
        final double width;

        Rectangle(double l, double w){
            this.length = l;
            this.width = w;
        }

        @Override
        double area() {
            return length * width;
        }
    }

    class Square extends Rectangle{
        Square(double side){
            super(side, side);
        }
    }

    public Circle getCircle(double radius){
        return new Circle(radius);
    }

    public Rectangle getRectagle(double l, double w){
        return new Rectangle(l, w);
    }

    public Square getSquare(double side){
        return new Square(side);
    }
}
