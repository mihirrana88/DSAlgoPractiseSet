package DS.Queue;

import Exception.InvalidInputArgument;

import java.util.Deque;
import java.util.LinkedList;

/*
Remove Duplicate Letters

Given a string s, remove duplicate letters so that every letter appears once and only once.
You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:
Input: s = "bcabc"
Output: "abc"

Example 2:
Input: s = "cbacdcbc"
Output: "acdb"

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.

*/

public class RemoveDuplicateLetters {
    public String inputString = null;

    public void acceptInputString(String inputString) throws Exception {
        if(null == inputString || inputString.length() == 0){
            throw new InvalidInputArgument(inputString);
        }
        this.inputString = inputString;
    }

    public String removeDuplicateLetters() {
        int len=inputString.length();
        char[] a=inputString.toCharArray();
        int[] frequency=new int[128];

        for(int i=0;i<len;i++)
        {
            frequency[a[i]]++;
        }

        Deque<Character> queue = new LinkedList<>();
        for(int i=0;i<len;i++)
        {
            if(queue.isEmpty())
            {
                queue.add(a[i]);
                frequency[a[i]]--;
                continue;
            }
            if(queue.contains(a[i]))
            {
                frequency[a[i]]--;
                continue;
            }

            while(!queue.isEmpty() && queue.getLast() > a[i] && frequency[queue.getLast()]>0)
            {
                queue.pollLast();
            }
            queue.add(a[i]);
            frequency[a[i]]--;

        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            sb.append(queue.pollFirst());
        }
        return sb.toString();
    }
}
