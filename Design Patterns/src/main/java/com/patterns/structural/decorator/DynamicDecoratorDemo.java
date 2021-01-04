package com.patterns.structural.decorator;

interface Shape {
    String info();
}

class Circle implements Shape {

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String info() {
        return "A circle of " + radius + " radius ";
    }
}

class Square implements Shape {

    private final int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public String info() {
        return "A Square of " + side + " side ";
    }
}

class ColoredShapeDecorator implements Shape {

    private final String color;
    private final Shape shape;

    public ColoredShapeDecorator(String color, Shape shape) {
        this.color = color;
        this.shape = shape;
    }

    @Override
    public String info() {
        return shape.info() + " having " + color + " color";
    }
}

class TransparencyShapeDecorator implements Shape {

    private final int transparency;
    private final Shape shape;

    public TransparencyShapeDecorator(int transparency, Shape shape) {
        this.transparency = transparency;
        this.shape = shape;
    }

    @Override
    public String info() {
        return shape.info() + " having " + transparency + "% transparency";
    }
}


public class DynamicDecoratorDemo {

    public static void main(String[] args) {
        Circle circle = new Circle(2.0);
        ColoredShapeDecorator coloredShapeDecorator = new ColoredShapeDecorator("Red", circle);
        System.out.println(coloredShapeDecorator.info());

        Square square = new Square(4);
        ColoredShapeDecorator coloredShapeDecorator1 = new ColoredShapeDecorator("Blue", square);
        TransparencyShapeDecorator transparencyShapeDecorator = new TransparencyShapeDecorator(50, coloredShapeDecorator1);
        System.out.println(transparencyShapeDecorator.info());
    }
}
