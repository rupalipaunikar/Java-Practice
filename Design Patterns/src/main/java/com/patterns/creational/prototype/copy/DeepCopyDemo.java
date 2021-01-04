package com.patterns.creational.prototype.copy;

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // copy constructor
    public Point(Point other) {
        this(other.x, other.y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Line {
    public Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // deep copy constructor
    public Line deepCopy() {
        return new Line(new Point(this.start), new Point(this.end));
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class DeepCopyDemo {

    public static void main(String[] args) {
        Point p1Start = new Point(1, 1);
        Point p1End = new Point(10, 10);
        Line line1 = new Line(p1Start, p1End);

        Line line2 = line1.deepCopy();
        line2.end.x = 300;

        System.out.println(line1);
        System.out.println(line2);
    }
}
