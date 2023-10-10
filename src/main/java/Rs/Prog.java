package Rs;

/*
* Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".



Example 1:

Input: address = "1.1.1.1"Output: "1[.]1[.]1[.]1"

Example 2:

Input: address = "255.100.50.0"Output: "255[.]100[.]50[.]0"


*
*
*
* */

import java.util.ArrayList;
import java.util.List;

public class Prog {

  public static void main(String[] args){
    System.out.println(defangedIP("1.1.1.1"));
    System.out.println(defangedIP("255.100.50.0"));
  }

  public static String defangedIP(String input){
    List<Character> lst = new ArrayList<>();

    for(char ch : input.toCharArray()){
      lst.add(ch);
    }

    StringBuilder sb = new StringBuilder();
    for(int i=0; i<input.length(); i++){
      if(input.charAt(i) == '.'){
        sb.append("[.]");
      }else{
        sb.append(input.charAt(i));
      }
    }
    return sb.toString();
  }
}

