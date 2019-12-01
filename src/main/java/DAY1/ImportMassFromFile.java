package DAY1;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImportMassFromFile {

    public List<Integer> importMassFromFile() throws URISyntaxException, IOException {
        Path path = Paths.get(getClass().getClassLoader()
                .getResource("day_one").toURI());

        Stream<Integer> lines = Files.lines(path).map(Integer::valueOf);

        return lines.collect(Collectors.toList());
    }
}
