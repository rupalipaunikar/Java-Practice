import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            final List<String> stringList = new ArrayList<>();
            stringList.add("Line 1");
            stringList.add("Line 2");
            stringList.add("Line 3");

            Path path = Paths.get("myfile.txt");
            Files.write(path, stringList, StandardOpenOption.CREATE);

            System.out.println(Files.readAllLines(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
