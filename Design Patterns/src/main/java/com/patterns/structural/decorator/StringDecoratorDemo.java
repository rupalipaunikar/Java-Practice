package com.patterns.structural.decorator;

class MagicString {
    private final String string;

    public MagicString(String string) {
        this.string = string;
    }

    public long getNumberOfVowels() {
        return string.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> "aeiou".contains(c.toString()))
                .count();
    }

    @Override
    public String toString() {
        return string;
    }

    // delegated members
    public int length() {
        return string.length();
    }
}

public class StringDecoratorDemo {

    public static void main(String[] args) {
        MagicString s = new MagicString("and");
        System.out.println(s + " has "
                + s.getNumberOfVowels() + " vowels");
    }
}
