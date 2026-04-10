package DS.Arrays;

import java.util.*;

public class ThreeSum2 {
    static Map<Integer, Integer[]> map = new TreeMap<>();
    static Set<Integer> kset = new HashSet<>();
    static List<Integer[]> ans = new ArrayList<>();
    public static void main(String[] args){
        int[] array = {12, 3, 1, 2, -6, 5, -8, 6};
        int targetSum = 0;
        //threeNumberSum(array, targetSum);
        for(Integer[] a : threeNumberSum(array, targetSum)){
            System.out.println(Arrays.toString(a));
        }
    }


    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);
        Set<String> kset = new HashSet<>();
        List<Integer[]> ans = new ArrayList<>();
        for(int i=0; i<array.length; i++){
            int target = targetSum - array[i];
            List<Integer[]> list = find2Sum(array, target);
            ans.addAll(addIntoAns(list, array[i], kset));
        }
        for(String s : kset){
            System.out.println(s);
        }
        return ans;
    }

    public static List<Integer[]> find2Sum(int[] array, int target){
        List<Integer[]> ans2Sum = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int num : array){
            if(set.contains(target-num)){
                if(num < (target - num)){
                    ans2Sum.add(new Integer[]{num, target-num});
                }else{
                    ans2Sum.add(new Integer[]{target-num, num});
                }
            }
            set.add(num);
        }

        Collections.sort(ans2Sum, (a, b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        return ans2Sum;
    }

    public static List<Integer[]> addIntoAns(List<Integer[]> list, int i, Set<String> kset){
        List<Integer[]> ans = new ArrayList<>();
        for(Integer[] arr : list){
            Integer[] key = new Integer[3];
            key[0] = i;
            key[1] = arr[0];
            key[2] = arr[1];
            Arrays.sort(key);
            StringBuilder sKey = new StringBuilder();
            for(int a : key){
                sKey.append(a);
            }
            if(!kset.contains(sKey.toString())){
                ans.add(key);
                kset.add(sKey.toString());
            }
            /*
            if(!kset.contains(i*arr[0]*arr[1])){
                if(arr[0] > i){
                    ans.add(new Integer[]{i, arr[0], arr[1]});
                }else if(arr[0] < i && arr[1] > i){
                    ans.add(new Integer[]{arr[0], i, arr[1]});
                }else if(arr[0] < i && arr[1] < i){
                    ans.add(new Integer[]{arr[0], arr[1], i});
                }
                kset.add(i*arr[0]*arr[1]);
            }*/
        }
        return ans;
    }
}
