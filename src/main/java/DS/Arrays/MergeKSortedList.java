package DS.Arrays;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedList {

    public void mergeKSortedList(){

        List<List<Integer>> input = new ArrayList<>();

        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(4);
        l1.add(5);
        l1.add(8);

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        l2.add(3);

        List<Integer> l3 = new ArrayList<>();
        l3.add(3);
        l3.add(4);
        l3.add(5);
        l3.add(6);
        l3.add(7);

        input.add(l1);
        input.add(l2);
        input.add(l3);

        List<Integer> ans = mergeKSortedList(input);

        for(int i : ans){
            System.out.println(i);
        }
    }

    public List<Integer> mergeKSortedList(List<List<Integer>> input){
        List<Integer> ans = new ArrayList<>();
        int k = input.size();
        List<Integer> pointers = new ArrayList<>();
        for(int i=0; i<k; i++){
            pointers.add(0);
        }

        int run = k;
        while(run>1){
            int pindex = 0;
            int smallestElement = Integer.MAX_VALUE;
            for(int i=0; i<k; i++){
                List<Integer> list = input.get(i);
                int pincr = pointers.get(i);
                if(pincr < list.size()){
                    if(list.get(pincr) <= smallestElement ){
                        smallestElement = list.get(pincr);
                        pindex = i;
                    }
                }
            }
            ans.add(smallestElement);
            int incr = pointers.get(pindex);
            incr++;
            pointers.set(pindex, incr);
            if(incr >= input.get(pindex).size()){
                run--;
            }
        }

        for(int i=0; i<k; i++){
            List<Integer> list = input.get(i);
            int pointer = pointers.get(i);
            while(pointer < list.size()){
                ans.add(list.get(pointer));
                pointer++;
                pointers.set(i, pointer);
            }
        }

        return ans;
    }
}
