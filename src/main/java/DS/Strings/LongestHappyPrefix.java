package DS.Strings;

import Exception.InvalidInputArgument;

public class LongestHappyPrefix {
    String inputString = null;

    public void acceptInputString(String inputString) throws Exception {
        if(null == inputString || inputString.length() == 0){
            throw new InvalidInputArgument(inputString);
        }
        this.inputString = inputString;
    }

    public String longestPrefix() {
        int n = inputString.length();
        int[] lps = new int[n];
        int index = 0 , i=1;
        while(i<n){
            if(inputString.charAt(i)==inputString.charAt(index)){
                lps[i] = index+1;
                i++;index++;
            }else{
                if(index!=0){
                    index = lps[index-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return inputString.substring(0,lps[n-1]);
    }
}
