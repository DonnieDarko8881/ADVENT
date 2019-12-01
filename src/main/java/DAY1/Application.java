package DAY1;

import java.io.IOException;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException, URISyntaxException {
        ImportMassFromFile importMassFromFile = new ImportMassFromFile();
        List<Integer> integers = importMassFromFile.importMassFromFile();

        int sum = integers.stream().mapToInt(mass -> (mass / 3) - 2).sum();
        System.out.println(sum);

    }
}
