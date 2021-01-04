public class Demo {

    public static void main(String[] args) {
        GenericClass<String, Integer> genericClass = new GenericClass<>("abc", 123);
        System.out.println(genericClass);
        genericClass.setValue(456);
        System.out.println(genericClass);
    }
}
