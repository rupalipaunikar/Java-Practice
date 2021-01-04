package com.patterns.creational.singleton;

import java.util.HashMap;
import java.util.Map;

enum SubSystem {
    LASER,
    AUX;
}

class Printer {

    public static int count = 0;
    private static final Map<SubSystem, Printer> printerMap = new HashMap<>();

    private Printer() {
        count++;
        System.out.println("Instantiating....");
    }

    public static Printer getInstance(SubSystem system) {
        if (printerMap.containsKey(system)) {
            return printerMap.get(system);
        } else {
            Printer printer = new Printer();
            printerMap.put(system, printer);
            return printer;
        }
    }
}

public class Multiton {
    public static void main(String[] args) {

        Printer p1 = Printer.getInstance(SubSystem.LASER);
        System.out.println(p1);

        Printer p2 = Printer.getInstance(SubSystem.AUX);
        System.out.println(p2);

        Printer p3 = Printer.getInstance(SubSystem.LASER);
        System.out.println(p3);

        Printer p4 = Printer.getInstance(SubSystem.AUX);
        System.out.println(p4);

        System.out.println(Printer.count);
    }

}
