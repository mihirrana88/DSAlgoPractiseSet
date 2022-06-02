package DS.Strings;

import Exception.InvalidInputArgument;

public class SwapAdjacentLRString {
    String start = null;
    String end = null;

    public void acceptInputString1(String string1) throws Exception {
        if(null == string1 || string1.length() == 0){
            throw new InvalidInputArgument(string1);
        }
        this.start = string1;
    }

    public void acceptInputString2(String string2) throws Exception {
        if(null == string2 || string2.length() == 0){
            throw new InvalidInputArgument(string2);
        }
        this.end = string2;
    }

    public boolean canTransform() {
        int f = 0;
        int s = 0;
        while(f < start.length() || s < end.length()) {
            while(f < start.length() && start.charAt(f) == 'X') f++;
            while(s < end.length() && end.charAt(s) == 'X') s++;
            if (f == start.length() || s == end.length()) return s == end.length() && f == start.length();
            char stChar = start.charAt(f);
            char enChar = end.charAt(s);
            if (stChar != enChar) return false;
            if (stChar == 'R' && f > s) return false;
            if (stChar == 'L' && f < s) return false;
            f++;
            s++;
        }
        return true;
    }
}
