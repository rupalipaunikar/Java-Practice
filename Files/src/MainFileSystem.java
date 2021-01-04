import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFileSystem {

    public static void main(String[] args) throws Exception {
        final List<String> stringList = new ArrayList<>();
        stringList.add("Line 1");
        stringList.add("Line 2");
        stringList.add("Line 3");

        final Path path = Paths.get("myZip.zip");
        final URI uri = new URI("jar:file", path.toUri().getPath(), null);
        final Map<String, String> map = new HashMap<>();
        map.put("create", "true");
        FileSystem zipFileSystem = FileSystems.newFileSystem(uri, map);

        Path sourcePath = Paths.get("myfile.txt");
        Path destPath = zipFileSystem.getPath("/myfileCopied.txt");
        Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);


        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(zipFileSystem.getPath("file1.txt"))) {
            for(String string : stringList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        Files.write(zipFileSystem.getPath("/file2.txt"), stringList, Charset.defaultCharset(),
                StandardOpenOption.CREATE);
    }
}
