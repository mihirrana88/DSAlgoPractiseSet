package Frtnt;
/*
* [1 5 2 9]
* 2
*
* [1 2 3 4 5]
*
* */
public class Problem {

  public static int findTheTargetInSorted(int[] arr, Integer target){

    //[1 2 3 4 5]

      if(null == arr){
        return -1;
      }

      int l = 0;
      int r = arr.length-1;  // 4
      int index = -1;
      while(l <= r){
        int m = l + (r-l)/2;   /// 2 [1, 2, 4, 4, 4, 5]
        if(arr[m] == target){
          if(m == 0){
            return m;
          }else if(arr[m-1] != target){
            return m;
          }
        }

        if(target <= arr[m]){
          r = m-1;
        }else{
          l = m+1; // l = 3
        }
      }
      return index;

      //Time COmplexity: O(logn)
      //Space COmplexity: O(1)
  }

  public static void main(String[] args){
    int[] arr = {4, 4, 4, 4, 4, 4};
    int target =4;
    System.out.println(findTheTargetInSorted(arr, target));
    System.out.println(findTheTargetInSorted(null, target));
  }

  /*
  * [3:46 PM] Sushant Pawar

 A -> B, C
 b-> C, D
 C-> D

  c D b -->


C-> A

[3:48 PM] Vikas Kumar

A -> B, C
b-> C, D
C-> D, A
A B C D

  *
  *
  * */


}
