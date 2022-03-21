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

    public String removeDuplicateLettersV2() {
        // to count the remaining alphabet letters
        int[] remaining = new int[26];
        // to count the alphabet letters used in the string
        int[] used = new int[26];

        final char[] CHS = inputString.toCharArray();

        final int L = inputString.length();
        for (int i = 0; i < L; ++i) {
            ++remaining[CHS[i] - 'a'];
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < L; ++i) {
            if (used[CHS[i] - 'a'] == 0) {
                // to pop out duplicates and bigger characters existing in the builder
                while (builder.length() > 0 && builder.charAt(builder.length() - 1) >= CHS[i]
                        && remaining[builder.charAt(builder.length() - 1) - 'a'] > 0) {

                    --used[builder.charAt(builder.length() - 1) - 'a'];
                    builder.deleteCharAt(builder.length() - 1);
                }

                builder.append(CHS[i]);
                ++used[CHS[i] - 'a'];
            }

            --remaining[CHS[i] - 'a'];
        }
        return builder.toString();
    }
}
