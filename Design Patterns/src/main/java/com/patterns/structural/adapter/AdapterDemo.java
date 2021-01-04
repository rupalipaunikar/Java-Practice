package com.patterns.structural.adapter;

class Square {
    public int side;

    public Square(int side) {
        this.side = side;
    }
}

interface Rectangle {
    int getWidth();

    int getHeight();

    default int getArea() {
        return getWidth() * getHeight();
    }
}

class SquareToRectangleAdapter implements Rectangle {

    private final Square sq;

    public SquareToRectangleAdapter(Square square) {
        this.sq = square;
    }

    @Override
    public int getWidth() {
        return sq.side;
    }

    @Override
    public int getHeight() {
        return sq.side;
    }
}

// this example adapts an object to an interface - square to rectangle
public class AdapterDemo {

    public static void main(String[] args) {
        Square s = new Square(2);
        Rectangle r1 = new SquareToRectangleAdapter(s);
        System.out.println(r1.getArea());
    }
}
