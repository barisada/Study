package desingPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecoratePattern {
    public static void main(String[] args) {
        DecoratePattern dp = new DecoratePattern();
        List<Shape> shapes = Arrays.asList(new Circle(2), new Rectangle(1,2));
        List<Shape> decoratedShapes = new ArrayList<>();
        shapes.forEach(shape ->{
            decoratedShapes.add(dp.createFillColorDecorator(shape, "RED"));
            System.out.println(shape.draw());
            System.out.println(shape.description());
        });
        System.out.println("******************** decorated *******************");
        decoratedShapes.forEach(shape -> {
            System.out.println(shape.draw());
            System.out.println(shape.description());
        });

    }

    public FillColorDecorator createFillColorDecorator(Shape shape, String color){
        return new FillColorDecorator(shape, color);
    }

    interface Shape{
        String draw();
        String description();
    }

    static class Circle implements Shape{
        double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public String draw() {
            return "drawing circle";
        }

        @Override
        public String description() {
            double area = Math.PI * radius * radius;
            return "this is a circle. Area is " + area + ".";
        }
    }

    static class Rectangle implements Shape{
        int width;
        int height;

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public String draw() {
            return "drawing rectangle";
        }

        @Override
        public String description() {
            int area = width * height;
            return "this is a rectangle. Area is " + area + ".";
        }
    }

    abstract class ShapeDecorator implements Shape{
        protected Shape decoratedShape;

        public ShapeDecorator(Shape decoratedShape) {
            this.decoratedShape = decoratedShape;
        }
    }

    public class FillColorDecorator extends ShapeDecorator {
        String color;
        public FillColorDecorator(Shape decoratedShape, String color) {
            super(decoratedShape);
            this.color = color;
        }

        @Override
        public String draw() {
            return decoratedShape.draw();
        }

        @Override
        public String description() {
            return decoratedShape.description() + " Color is "  + color;
        }
    }
}
