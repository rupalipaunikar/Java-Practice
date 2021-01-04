package com.patterns.structural.bridge;

abstract class Shape {

    protected final Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract String getName();
}

class Triangle extends Shape {

    public Triangle(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String getName() {
        return "Triangle";
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
    }
}

class VectorTriangle extends Triangle {

    public VectorTriangle(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
    }
}

class RasterTriangle extends Triangle {

    public RasterTriangle(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
    }
}

class Square extends Shape {

    public Square(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String getName() {
        return "Square";
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
    }
}

class VectorSquare extends Square {

    public VectorSquare(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
    }
}

class RasterSquare extends Square {

    public RasterSquare(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
    }
}

interface Renderer {
    String whatToRenderAs();
}

class VectorRenderer implements Renderer {

    @Override
    public String whatToRenderAs() {
        return "lines";
    }
}

class RasterRenderer implements Renderer {

    @Override
    public String whatToRenderAs() {
        return "pixels";
    }
}

public class BridgeDemo {

    public static void main(String[] args) {

        VectorTriangle vectorTriangle = new VectorTriangle(new VectorRenderer());
        System.out.println(vectorTriangle);

        Triangle triangle = new Triangle(new VectorRenderer());
        System.out.println(triangle);

        Triangle triangle1 = new Triangle(new RasterRenderer());
        System.out.println(triangle1);

        RasterTriangle rasterTriangle = new RasterTriangle(new RasterRenderer());
        System.out.println(rasterTriangle);
    }
}
