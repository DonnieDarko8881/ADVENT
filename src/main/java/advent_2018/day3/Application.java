package advent_2018.day3;

import advent_2018.FetchDataFromFile;
import sun.rmi.server.InactiveGroupException;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int result =0;
        FetchDataFromFile fetchDataFromFile = new FetchDataFromFile();
        List<String> strings = fetchDataFromFile.fetchDataToStringList("day3_2018/day_three");
        int[][] arrInt = new int[1000][1000];
        for (int i = 0; i <strings.size() ; i++) {
                int[] data = changeStringToArray(strings.get(i));
                for (int right = 0; right < data[2] ; right++) {
                    for (int down = 0; down < data[3] ; down++) {
                        arrInt[data[1]+down][data[0]+right] +=1;
                    }
                }
        }

        for (int k = 0; k <arrInt.length ; k++) {
            for (int l = 0; l <arrInt.length ; l++) {
                if(arrInt[k][l]>1){
                    result++;
                }
            }
        }

        for (int i = 0; i <strings.size() ; i++) {
            int[] data = changeStringToArray(strings.get(i));
            int countIfClaimsCounter =0;
            int squar = data[2]*data[3];
            for (int right = 0; right < data[2] ; right++) {
                for (int down = 0; down < data[3] ; down++) {
                    if( arrInt[data[1]+down][data[0]+right]==1){
                        countIfClaimsCounter++;
                    }
                }
                if(countIfClaimsCounter==squar){
                    System.out.println(data[4]);
                }
            }
        }

        System.out.println(result);
    }

    public static int[] changeStringToArray(String string){
        String[] withoutAt = string.split("@");
        String[] withoutColon = withoutAt[1].split(":");
        String[] withoutComa = withoutColon[0].split(",");
        String[] withoutX = withoutColon[1].split("x");

        Integer y = Integer.valueOf(withoutComa[0].trim());//568
        Integer x = Integer.valueOf(withoutComa[1].trim());//365
        Integer right = Integer.valueOf(withoutX[0].trim()); //26
        Integer down = Integer.valueOf(withoutX[1].trim()); //19
        Integer id = Integer.valueOf(withoutAt[0].trim().substring(1));
        return new int[]{y, x, right, down, id};
    }
}
