package DS.DynamicProgramming;

import Exception.InvalidInputArgument;

public class DecodeWays {
    String inputString = null;

    public void acceptInputString(String inputString) throws Exception {
        if(null == inputString || inputString.length() == 0){
            throw new InvalidInputArgument(inputString);
        }
        this.inputString = inputString;
    }

    public int getDecodeWaysCount() {
        int n = inputString.length();
        int[] dp = new int[n+1];

        //if first character is 0
        if(inputString.charAt(0) == '0')
            return 0;

        dp[0] = 1;
        dp[1] = 1;

        //dp[i] contains ans of (i-1) length
        for(int i = 2; i <= n; i++){
            char c = inputString.charAt(i-1);

            if(c == '0'){
                // if c is 0 then prev charcter must be 1 or 2 else we will get invalid encoding
                if(inputString.charAt(i-2) != '1' && inputString.charAt(i-2) != '2')
                    return 0;
                //if we get 10 or 20 then these characters will be grouped together and cannot be
                //grouped with other character individually
                dp[i] = dp[i-2];
            }
            //if the number formed by combining prev and current character is not in range [1,26]
            //then they can't be grouped and our ans will be same as dp[i-1]
            else if(inputString.charAt(i-2) == '0' || inputString.charAt(i-2) > '2' || c > '6' &&  inputString.charAt(i-2) == '2'){
                dp[i] = dp[i-1];
            }
            //if it is in range [1,26]
            else
                dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[n];
    }
}
