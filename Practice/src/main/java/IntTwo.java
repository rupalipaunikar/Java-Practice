public interface IntTwo {

    void common();

    default void common1() {
        System.out.println("Default method 2");
    }
}
