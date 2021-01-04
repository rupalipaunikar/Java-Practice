import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraysPractice {

    private static boolean checkDuplicatesUsingBruteForce(Integer a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i].equals(a[j]) && i != j) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int[] replaceDuplicatesWithZero(int a[]) {
        int[] result = new int[a.length];
        int previous = a[0];
        result[0] = previous;

        for (int i = 1; i < a.length; i++) {
            int ch = a[i];
            if (previous != ch) {
                result[i] = ch;
            }
            previous = ch;
        }
        return result;
    }

    private static boolean checkDuplicatesUsingSet(Integer a[]) {
        Set<Integer> set = new HashSet<>(Arrays.asList(a));
        return set.size() != a.length;
    }

    private static boolean checkDuplicatesUsingSetAdd(Integer a[]) {
        Set<Integer> set = new HashSet<>();
        for (Integer in : a) {
            boolean isAddSuccessful = set.add(in);
            if (!isAddSuccessful) {
                return true;
            }
        }
        return false;
    }

    private static int findMissingNumber(int[] numbers, int length) {
        int expectedSum = (length * (length + 1)) / 2;
        int actualSum = 0;
        for (int i : numbers) {
            actualSum += i;
        }
        return expectedSum - actualSum;
    }

    private static int findSmallestNumber(int[] a) {
        int smallest = Integer.MAX_VALUE;
        for (int n : a) {
            if (n < smallest) {
                smallest = n;
            }
        }
        return smallest;
    }

    private static int findLargestNumber(int[] a) {
        int largest = Integer.MIN_VALUE;
        for (int n : a) {
            if (n > largest) {
                largest = n;
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        Integer a[] = {1, 2, 4};
        int b[] = {1, 2, 4, 0, 9};
        System.out.println("checkDuplicatesUsingBruteForce -- " + checkDuplicatesUsingBruteForce(a));
        System.out.println("checkDuplicatesUsingSet -- " + checkDuplicatesUsingSet(a));
        System.out.println("checkDuplicatesUsingSetAdd -- " + checkDuplicatesUsingSetAdd(a));
        System.out.println("findMissingNumber -- " + findMissingNumber(b, 10));
        System.out.println("replaceDuplicatesWithZero -- ");
        /*b = replaceDuplicatesWithZero(b);
        for (int i : b) {
            System.out.print(" "+i);
        }*/

        System.out.println("findSmallestNumber -- " + findSmallestNumber(b));
        System.out.println("findLargestNumber -- " + findLargestNumber(b));
    }
}
