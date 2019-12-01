package advent_2018.day1;

import advent_2018.FetchDataFromFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        FetchDataFromFile fetchDataFromFile = new FetchDataFromFile();
        List<Integer> integers = fetchDataFromFile.fetchDataToIntegerList("advent_2018/day_one");
        //First
        int sum = integers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        //second
        Map<Integer, Integer> frequences = new HashMap<>();
        boolean end = true;
        int result = 0;
        int iterationWhile = 0;
        while(end) {
            iterationWhile++;
            for (int i = 0; i < integers.size(); i++) {
                result += integers.get(i);
                if (frequences.containsKey(result)) {
                    System.out.println("first reaches " + result + " twice");
                    System.out.println(iterationWhile++);
                    end =false;
                    break;
                } else {
                    frequences.put(result, 1);
                }
            }
        }
    }
}
