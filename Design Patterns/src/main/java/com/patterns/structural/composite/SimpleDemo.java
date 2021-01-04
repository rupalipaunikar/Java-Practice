package com.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

class GraphicObject {

    protected String name;
    private List<GraphicObject> graphicObjects = new ArrayList<>();

    public GraphicObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GraphicObject> getGraphicObjects() {
        return graphicObjects;
    }

    public void setGraphicObjects(List<GraphicObject> graphicObjects) {
        this.graphicObjects = graphicObjects;
    }



    @Override
    public String toString() {
        return "GraphicObject{" +
                "name='" + name + '\'' +
                ", graphicObjects=" + graphicObjects +
                '}';
    }
}

class Circle extends GraphicObject {

    public Circle(String name) {
        super(name);
    }
}

class Square extends GraphicObject {

    public Square(String name) {
        super(name);
    }
}

public class SimpleDemo {

    public static void main(String[] args) {
        GraphicObject circle1 = new Circle("Circle 1");
        GraphicObject square1 = new Square("Square 1");
        List<GraphicObject> list1 = new ArrayList<>();
        list1.add(circle1);
        list1.add(square1);
        GraphicObject group1 = new GraphicObject("group");
        group1.setGraphicObjects(list1);

        GraphicObject circle2 = new Circle("Circle");

        GraphicObject finalGroup = new GraphicObject("final group");
        finalGroup.getGraphicObjects().add(group1);
        finalGroup.getGraphicObjects().add(circle2);


        System.out.println(finalGroup);
    }

}
