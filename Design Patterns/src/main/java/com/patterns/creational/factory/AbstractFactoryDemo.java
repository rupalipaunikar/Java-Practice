package com.patterns.creational.factory;

enum FactoryType {
    TWO_DIMENSION,
    THREE_DIMENSION
}

enum ShapeType {
    LINE,
    SPHERE
}

class FactoryProvider {

    public static AbstractShapeFactory getFactory(FactoryType factoryType) {
        switch (factoryType) {
            case TWO_DIMENSION:
                return new TwoDimensionShapeFactory();
            case THREE_DIMENSION:
                return new ThreeDimensionShapeFactory();
            default:
                return null;
        }
    }
}

abstract class AbstractShapeFactory {

    abstract GeometricShape getShape(ShapeType shapeType);

}

class TwoDimensionShapeFactory extends AbstractShapeFactory {

    @Override
    GeometricShape getShape(ShapeType shapeType) {
        switch (shapeType) {
            case LINE:
                return new Line();
            default:
                return null;
        }
    }
}

class ThreeDimensionShapeFactory extends AbstractShapeFactory {

    @Override
    GeometricShape getShape(ShapeType shapeType) {
        switch (shapeType) {
            case SPHERE:
                return new Sphere();
            default:
                return null;
        }
    }
}

interface GeometricShape {
    void draw();
}

class Line implements GeometricShape {

    @Override
    public void draw() {
        System.out.println("Drawing a line.....");
    }
}

class Sphere implements GeometricShape {

    @Override
    public void draw() {
        System.out.println("Drawing a sphere.....");
    }
}

public class AbstractFactoryDemo {

    public static void main(String[] args) {
        AbstractShapeFactory shapeFactory = FactoryProvider.getFactory(FactoryType.TWO_DIMENSION);
        GeometricShape shape = shapeFactory.getShape(ShapeType.LINE);
        shape.draw();

        AbstractShapeFactory shapeFactory1 = FactoryProvider.getFactory(FactoryType.THREE_DIMENSION);
        GeometricShape shape1 = shapeFactory1.getShape(ShapeType.SPHERE);
        shape1.draw();
    }
}
