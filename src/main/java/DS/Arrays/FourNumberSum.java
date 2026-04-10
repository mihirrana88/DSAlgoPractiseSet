package DS.Arrays;

import java.io.File;
import java.net.MalformedURLException;
import java.util.*;

public class FourNumberSum {
    public static void main(String[] args) throws MalformedURLException {
        int[] array = {7, 6, 4, -1, 1, 2};
        int targetSum = 16;
        System.out.println("Hi Mihir");
        // Time Complexity of function: O(n^3)
        System.out.println(new File("path_to_file").toURI().toURL());
        for(Integer[] arr : fourNumberSum(array, targetSum)){
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("----------------------------------------------");

        Mihir m = new Mihir("Mihir", 88);
        Mihir m2 = new Mihir("rana", 89);
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, m);
        map.put(2, m2);

        Mihir m3 = (Mihir) map.get(1);
        Mihir m4 = (Mihir) map.get(2);

        System.out.println(m3.name+" && "+m3.number);
        System.out.println(m4.name+" && "+m4.number);


    }

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum){
        Arrays.sort(array);
        List<Integer[]> ans = new ArrayList<>();
        for(int i=0; i<array.length-3; i++){
            int first = array[i];
            for(int j=i+1; j<array.length-2; j++){
                int second = array[j];
                int left = j+1;
                int right = array.length-1;
                while(left < right){
                    int target = first + second + array[left] + array[right];
                    if(target == targetSum){
                        ans.add(new Integer[]{first, second, array[left], array[right]});
                        left++;
                        right--;
                    }else if(target<targetSum){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
