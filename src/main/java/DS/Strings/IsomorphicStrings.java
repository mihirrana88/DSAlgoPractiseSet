package DS.Strings;

import Exception.InvalidInputArgument;

/*
Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of
characters. No two characters may map to the same character, but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true

Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true


Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.

*/

public class IsomorphicStrings {
    String s = null;
    String t = null;

    public void acceptInputString(String s) throws Exception {
        if(null == s || s.length() == 0){
            throw new InvalidInputArgument(s);
        }
        this.s = s;
    }

    public void acceptInputPattern(String t) throws Exception {
        if(null == t || t.length() == 0){
            throw new InvalidInputArgument(t);
        }
        this.t = t;
    }

    public boolean isIsomorphic() {
        if( s.length() != t.length()) return false;
        int[] first = new int[256];
        boolean[] marked = new boolean[256];
        //initialising both arrays
        for(int i=0;i<256;i++)
        {
            first[i] = -1;
            marked[i] = false;
        }

        for(int i=0 ; i<s.length();i++)
        {
            if(first[s.charAt(i)] == -1 )
            {
                // if incase it is marked with another charcter return false
                if(marked[t.charAt(i)]) return false;
                //replacing "s" string char with "t" char
                first[(int)( s.charAt(i))] = t.charAt(i);
                marked[t.charAt(i)] = true;
            }
            else
            {
                if(first[(int) (s.charAt(i))] != t.charAt(i))
                {
                    return false;
                }

            }
        }
        return true;
    }
}
