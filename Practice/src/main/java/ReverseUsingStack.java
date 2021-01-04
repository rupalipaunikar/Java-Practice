import java.util.Stack;

public class ReverseUsingStack {

    public static void main(String[] args) {
        ReverseUsingStack reverseUsingStack = new ReverseUsingStack();
        reverseUsingStack.reverseString("Rupali");
    }

    private void reverseString(String input) {
        Stack<Character> stack = new Stack<>();
        char[] characters = input.toCharArray();

        for (char c : characters) {
            stack.push(c);
        }
        System.out.println(stack);

        for (int i = 0; i < characters.length; i++) {
            characters[i] = stack.pop();
        }
        System.out.println(characters);
        System.out.println(String.copyValueOf(characters));
    }
}
