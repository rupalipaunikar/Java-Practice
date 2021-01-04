package com.patterns.structural.composite;

import java.util.*;

//Component
interface ValueContainer extends Iterable<Integer> {
    int getValue();
}

// Leaf
class SingleValue implements ValueContainer {

    public int value;

    public SingleValue(int value) {
        this.value = value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return Collections.singleton(value).iterator();
    }

    @Override
    public int getValue() {
        return value;
    }
}

//Composite level 1
class ManyValues extends ArrayList<Integer> implements ValueContainer {

    @Override
    public int getValue() {
        int sum = 0;
        for (Integer integer : this) {
            sum = sum + integer;
        }
        return sum;
    }
}

//Composite level 2
class MyList extends ArrayList<ValueContainer> {

    public MyList(Collection<? extends ValueContainer> c) {
        super(c);
    }

    public int sum() {
        int sum = 0;

        for (ValueContainer valueContainer : this) {
            sum = sum + valueContainer.getValue();
        }
        return sum;
    }
}

public class ComplexDemo {

    public static void main(String[] args) {
        SingleValue s1 = new SingleValue(1);
        SingleValue s2 = new SingleValue(2);

        ManyValues m1 = new ManyValues();
        m1.add(1);
        m1.add(2);

        List<ValueContainer> valueContainers = new ArrayList<>();
        valueContainers.add(s1);
        valueContainers.add(s2);
        valueContainers.add(m1);

        MyList finalList = new MyList(valueContainers);
        int result = finalList.sum();


        System.out.println(result);
    }
}
