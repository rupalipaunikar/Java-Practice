public interface IntOne extends IntTwo {

    void common();

    default void common1() {
        System.out.println("Default method 1");
    }

    static void common2() {
        System.out.println("Static method");
    }

}
