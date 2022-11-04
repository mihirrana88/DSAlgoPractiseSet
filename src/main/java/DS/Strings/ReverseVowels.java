package DS.Strings;

import Exception.InvalidInputArgument;

import java.util.HashSet;
import java.util.Set;

/*
Reverse Vowels of a String

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:
Input: s = "hello"
Output: "holle"

Example 2:
Input: s = "leetcode"
Output: "leotcede"

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.

*/

public class ReverseVowels {
    String inputstring = null;

    public void acceptInputString(String inputstring) throws Exception {
        if(null == inputstring || inputstring.length() == 0){
            throw new InvalidInputArgument(inputstring);
        }
        this.inputstring = inputstring;
    }

    public String reverseVowels() {

        StringBuilder string = new StringBuilder(inputstring);
        int left = 0;
        int right = inputstring.length()-1;

        Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        vowelSet.add('A');
        vowelSet.add('E');
        vowelSet.add('I');
        vowelSet.add('O');
        vowelSet.add('U');

        while(left < right){

            char leftChar = string.charAt(left);
            char rightChar = string.charAt(right);

            if(vowelSet.contains(leftChar) && vowelSet.contains(rightChar)){
                string.setCharAt(left, rightChar);
                string.setCharAt(right, leftChar);
                left++;
                right--;
            }else if(!vowelSet.contains(leftChar) && vowelSet.contains(rightChar)){
                left++;
            }else if(vowelSet.contains(leftChar) && !vowelSet.contains(rightChar)){
                right--;
            }else{
                left++;
                right--;
            }
        }

        return string.toString();
    }
}
