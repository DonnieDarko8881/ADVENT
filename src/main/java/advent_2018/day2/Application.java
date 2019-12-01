package advent_2018.day2;

import advent_2018.FetchDataFromFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    static int count2 = 0;
    static int count3 = 0;
    public static void main(String[] args) {
        FetchDataFromFile fetchDataFromFile = new FetchDataFromFile();
        List<String> strings = fetchDataFromFile.fetchDataToStringList("day2_2018/day_two");
        //First PART
        for (int i = 0; i <strings.size() ; i++) {
            ifAppearTwoOrThree(strings.get(i));
        }
        System.out.println(count2 * count3);

        //second PART
        int iteration =0;
        int position = 0;
        for (int i = 0; i <strings.size() ; i++) {
            for (int j = i; j <strings.size() ; j++) {
                iteration++;
                int result=0;
                for (int k = 0; k <strings.get(0).length() ; k++) {
                    if(i==j){
                        continue;
                    }
                    if(strings.get(i).charAt(k)!=strings.get(j).charAt(k)){
                        position =k;
                        result++;
                    }
                }
                if(result==1){
                    System.out.println(strings.get(i)+ " " +strings.get(j));
                    System.out.println(strings.get(i).substring(0,position) +strings.get(i).substring(position+1));
                }
            }

        }
        System.out.println(iteration);
    }

    private static Map<Character, Integer> getMapOfFrequencyOfCharacterInString(String string){
        char[] chars = string.toCharArray();
        Map<Character,Integer> frequency = new HashMap<>();
        for (int i = 0; i <chars.length ; i++) {
            if(frequency.containsKey(chars[i])){
                frequency.put(chars[i], frequency.get(chars[i])+1);
            } else {
                frequency.put(chars[i], 1);
            }
        }
        return frequency;
    }

    private static void ifAppearTwoOrThree(String string){
        Map<Character, Integer> mapOfFrequencyOfCharacterInString = getMapOfFrequencyOfCharacterInString(string);
        if(mapOfFrequencyOfCharacterInString.containsValue(2)) {
            count2++;
        }
        if(mapOfFrequencyOfCharacterInString.containsValue(3)){
            count3++;
        }
    }
}
