package DS.HashMap;

import Exception.InvalidInputArgument;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations
that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.


Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].

*/

public class LetteCombinations {
    public String digits = null;

    List<String> list=new ArrayList<>();
    HashMap<Character,ArrayList<Character>> map=new HashMap<>();

    public void acceptInputString(String digits) throws Exception {
        if(null == digits || digits.length() == 0){
            throw new InvalidInputArgument(digits);
        }
        this.digits = digits;
    }

    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return new ArrayList<>();
        map.put('2',new ArrayList<>(Arrays.asList('a','b','c')));
        map.put('3',new ArrayList<>(Arrays.asList('d','e','f')));
        map.put('4',new ArrayList<>(Arrays.asList('g','h','i')));
        map.put('5',new ArrayList<>(Arrays.asList('j','k','l')));
        map.put('6',new ArrayList<>(Arrays.asList('m','n','o')));
        map.put('7',new ArrayList<>(Arrays.asList('p','q','r','s')));
        map.put('8',new ArrayList<>(Arrays.asList('t','u','v')));
        map.put('9',new ArrayList<>(Arrays.asList('w','x','y','z')));
        computePerm("",digits);
        return list;
    }
    private void computePerm(String p,String up){
        if(up.isEmpty()){
            list.add(p);
            return;
        }
        Character t=up.charAt(0);
        ArrayList<Character> l=map.get(t);
        for(Character item:l){
            computePerm(p+item,up.substring(1));
        }
    }
}
