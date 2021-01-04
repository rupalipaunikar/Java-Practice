import java.util.List;

public class NormalClass {

    private String name;
    private Integer id;
    private String address;

    public <T extends Number> T addNumbers(List<T> numbers ){
        T sum = null;
        for (final T t : numbers) {
            sum = t;
        }
        return sum;
    }
}
