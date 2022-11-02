package DS.DFSBFS;

import Exception.InvalidInputArgument;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
Minimum Genetic Mutation

A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string start to a gene string end where one mutation
is defined as one single character changed in the gene string.

For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it
a valid gene string.

Given the two gene strings start and end and the gene bank bank, return the minimum number of mutations
needed to mutate from start to end. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.

Example 1:
Input: start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
Output: 1

Example 2:
Input: start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
Output: 2

Example 3:
Input: start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
Output: 3


Constraints:

start.length == 8
end.length == 8
0 <= bank.length <= 10
bank[i].length == 8
start, end, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].

*/

public class MinimumGeneticMutation {
    String start = null;
    String end = null;
    public String[] bank = null;

    public void acceptInputBank(String mutation) throws Exception {
        if(null == mutation || mutation.length() == 0){
            throw new InvalidInputArgument(mutation);
        }
        char[] inputCharArray = mutation.toCharArray();
        this.bank = new String[inputCharArray.length];
        for (int i=0; i < inputCharArray.length; i++){
            this.bank[i] = String.valueOf(inputCharArray[i]);
        }
    }

    public void acceptInputStart(String start) throws Exception {
        if(null == start || start.length() == 0){
            throw new InvalidInputArgument(start);
        }
        this.start = start;
    }

    public void acceptInputEnd(String end) throws Exception {
        if(null == end || end.length() == 0){
            throw new InvalidInputArgument(end);
        }
        this.end = end;
    }

    public int minMutation() {
        int level = 0;
        int len = bank.length;
        char[] chr = {'A','C','G','T'};

        Set<String> hset = new HashSet<String>();
        for(String s: bank){
            hset.add(s);
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        while(true){
            level++;
            int n = queue.size();

            if(n == 0){
                return -1;
            }

            for(int i =0; i < n; i++){
                char[] ch = queue.poll().toCharArray();

                for(int j =0; j < 8; j++){
                    char org_char = ch[j];
                    for(int c = 0; c<4; c++){
                        ch[j] = chr[c];
                        String str = String.valueOf(ch);
                        if(str.equals(end)
                                && hset.contains(str)){
                            return level;
                        }

                        if(!hset.contains(str)){
                            continue;
                        }

                        hset.remove(str);
                        queue.add(str);
                    }
                    ch[j] = org_char;
                }
            }
        }
    }
}
