package Rs;

/*
* Given sequence of numbers and window size, print duplicate numbers in each window
E.g. data = [1, 2, 3, 4, 4, 5] and window = 4
Window 1 = None --> [1 2 3 4]
Window 2 = 4 -->[2, 3, 4, 4]
Window 3 = 4 -->  [3, 4, 4, 4]

[1, 2, 3, 4, 4, 5, 4] and window = 4
* */

import java.util.HashMap;
import java.util.Map;

public class Prog2 {

  public static void main(String[] args){
    int[] arr = {1, 2, 3, 4, 4, 5};
    printRepeatedNumFromWindow(arr, 4);
  }

  public static void printRepeatedNumFromWindow(int[] arr, int window){
        Map<Integer, Integer> mapCount = new HashMap<>();
        for(int i = 0; i<window; i++){
          mapCount.put(arr[i], mapCount.getOrDefault(arr[i], 0)+1);
        }

        printRepeatedNumberFromMap(mapCount);
        System.out.println("1st window executed");

      int i = 1;
      int j = window;

      while(j<arr.length){
        mapCount.put(arr[j], mapCount.getOrDefault(arr[j], 0)+1);
        if(mapCount.get(arr[i-1])>1){
          mapCount.put(arr[i-1], mapCount.get(arr[i-1])-1);
        }else {
          mapCount.remove(arr[i-1]);
        }
        printRepeatedNumberFromMap(mapCount);
        System.out.println("next window executed");
        i++;
        j++;
      }
  }

  public static void printRepeatedNumberFromMap(Map<Integer, Integer> m){
      for(Map.Entry<Integer, Integer> entry : m.entrySet()){
        if(entry.getValue() > 1){
          System.out.println(entry.getKey()+" ");
        }
      }
  }

}
