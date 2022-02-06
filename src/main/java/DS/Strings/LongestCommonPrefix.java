package DS.Strings;

import Exception.InvalidInputArgument;

public class LongestCommonPrefix {
    public String[] strings = null;

    public void getInputLength(int len){
        strings = new String[len];
    }

    public void acceptInput(String str, int index){
        if(index < 0 || index >= strings.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        strings[index] = str;
    }

    public String longestCommonPrefix() throws Exception {



        if(strings.length == 0){
            return "";
        }

        if(strings.length == 1){
            return strings[0];
        }

        int minLen = getMinimumLen();

        if(minLen == 0){
            return "";
        }

        String lcp = "";

        for(int i=0; i<minLen; i++){

            for(int j=1; j<strings.length; j++){
                System.out.println("mihir");
                System.out.println(minLen);
                System.out.println(strings[0].charAt(i));
                System.out.println(strings[j].charAt(i));
                if(strings[0].charAt(i) != strings[j].charAt(i)){
                    return lcp;
                }
            }

            lcp = lcp+strings[0].charAt(i);
        }

        return lcp;
    }

    public int getMinimumLen(){
        int min = strings[0].length();
        for(int i=1; i<strings.length; i++){
            if(strings[i].length() == 0){
                return 0;
            }
            System.out.println("ml");
            min = Math.min(strings[i].length(), min);
        }
        return min;
    }
}
