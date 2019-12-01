package advent_2018;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FetchDataFromFileFromResources {
    public List<Integer> fetchDataToIntegerList(String fileFromResources) {
        Stream<Integer> lines = null;
        try {
            lines = Files.lines(getPath(fileFromResources)).map(Integer::valueOf);
        } catch (IOException e) {

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return lines.collect(Collectors.toList());
    }

    private Path getPath(String fileFromResources) throws URISyntaxException {
        return Paths.get(getClass().getClassLoader()
                .getResource(fileFromResources).toURI());

    }

}
