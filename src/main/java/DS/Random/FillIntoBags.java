package DS.Random;

import java.util.HashMap;
import java.util.Map;

public class FillIntoBags {

  public static void main(String[] args){
    int[] nums = {5, 1, 5, 4, 3, 6, 1, 9, 5, 1};
    Map<Integer, Integer> map = new HashMap<>();

    for(int i=0; i<nums.length; i++){
      map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
    }

    int totalNumberOfBags = 4;
    int bagWeight = 10;
    while (totalNumberOfBags>0){
      for(int i=10; i>0; i--){
        if(map.containsKey(i)){
          if(bagWeight>=i){
            System.out.print("--"+i+"--");
            bagWeight = bagWeight - i;
            int quant = map.get(i) - 1;
            if(quant <= 0){
              map.remove(i);
            }else{
              map.put(i, quant);
            }
          }
        }
        if(bagWeight <= 0){
          System.out.println();
          System.out.println(totalNumberOfBags);
          totalNumberOfBags--;
          bagWeight = 10;
        }
      }
      //System.out.println(totalNumberOfBags);
      //System.out.println(map);
      //System.out.println("--totalNumberOfBags--"+totalNumberOfBags);
      if(map.isEmpty()){
        break;
      }
    }
    //System.out.println("jhihihi");
    System.out.println();
    System.out.println();
    System.out.println(map.isEmpty());

  }
}
