package DS.Recursion;

import Exception.InvalidInputArgument;

public class PalindromeString {
    String inputString = null;

    public void acceptInputString(String inputString) throws Exception {
        if(null == inputString || inputString.length() == 0){
            throw new InvalidInputArgument(inputString);
        }
        this.inputString = inputString;
    }

    public boolean isPalindrome(){
        String s = inputString.toLowerCase()
                .replaceAll("\\s", "")
                .replaceAll("\\p{Punct}", "");

        return isPalindrome(s, 0, s.length()-1);
    }

    private boolean isPalindrome(String s, int l, int r){
        if(l>=r){
            return true;
        }

        System.out.println(s.charAt(l)+" compares to "+s.charAt(r));

        if(s.charAt(l) != s.charAt(r)){
            return false;
        }

        return isPalindrome(s, l+1, r-1);
    }
}
