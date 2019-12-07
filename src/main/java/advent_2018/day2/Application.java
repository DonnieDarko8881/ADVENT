package advent_2018.day2;

import advent_2018.FetchDataFromFile;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        FetchDataFromFile fetchDataFromFile = new FetchDataFromFile();

       exercise1(fetchDataFromFile.fetchDataToIntegerArray("day_two"));

        int result_ex2 = exercise2(fetchDataFromFile);
        System.out.println(result_ex2);
    }

    private static int exercise2(FetchDataFromFile fetchDataFromFile) {
        for (int noun = 0; noun <100 ; noun++) {
            for (int verb = 0; verb <100 ; verb++) {
                int integerArray[] = fetchDataFromFile.fetchDataToIntegerArray("day_two");
                integerArray[1] = noun;
                integerArray[2] = verb;
                changeArrayPartOne(integerArray);

                if(integerArray[0] == 19690720){
                    System.out.println(noun + "  " + verb);
                    return noun*100 + verb;
                }
            }
        }
        return 0;
    }


    private static void exercise1(int[] integerArray){
        integerArray[1] = 12;
        integerArray[2] = 2;
        changeArrayPartOne(integerArray);
        System.out.println(integerArray[0]);

    }

    private static void changeArrayPartOne(int[] integerArray) {
        for (int i = 0; i <integerArray.length; i+=4) {
            if(integerArray[i]==99){
                break;
            }
            int first = integerArray[i + 1];
            int second = integerArray[i  + 2];
            int third = integerArray[i+3];

            if(integerArray[i]==1) {
                integerArray[third] = integerArray[first] + integerArray[second];
            } else if(integerArray[i]==2) {
                integerArray[third] = integerArray[first] * integerArray[second];
            }
        }
    }
}
