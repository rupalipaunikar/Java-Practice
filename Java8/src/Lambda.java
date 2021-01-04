import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SplittableRandom;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Lambda {

    public static void main(String[] args) {
        final FileFilter fileFilter = (File pathname) -> pathname.getName().endsWith(".java");
        File dir = new File("d:/tmp");
        File[] files = dir.listFiles(fileFilter);

        if(files != null && files.length !=0) {
            List<File> fileList = Arrays.asList(files);
            //fileList.forEach((file -> System.out.println(file)));
            fileList.forEach(System.out::println);
        }



        Predicate<String> p1 = s1 -> s1.length() > 20;
        Predicate<String> p2 = s2 -> s2.length() < 30;
        Predicate<String> p3 = p1.and(p2);




        List<String> strings = Arrays.asList("abc", "pqr");
        List<String> result = new ArrayList<>();

        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = result::add;

        strings.forEach(c1.andThen(c2));

        System.out.println("Result size - "+result.size());
     }
}
