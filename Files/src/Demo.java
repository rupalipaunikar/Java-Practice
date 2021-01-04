import java.util.StringJoiner;

public class Demo {

    public static void main(String[] args) {
        final StringJoiner stringJoiner = new StringJoiner(", ", "(", ")");
        stringJoiner.add("abc");
        stringJoiner.add("123");
        stringJoiner.add("xyx");

        System.out.println(stringJoiner.toString());
    }
}
