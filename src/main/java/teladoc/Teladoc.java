package teladoc;

/*Palindrom
*
* 121
*
*
*  TestCases
*     --> InputNumberValidation
*     --> OnePositveTestCase
*     --> OneNegativeTestCase
*     --> TestForSingleDigitInput
*
* */

public class Teladoc {

  public static void main(String[] args) throws Exception {
    System.out.println(isPalindrome(121));
    System.out.println(isPalindrome(0));
    System.out.println(isPalindrome(8));
    System.out.println(isPalindrome(123321));
    System.out.println(isPalindrome(1234));
    System.out.println(isPalindrome(123421));
    System.out.println(isPalindrome(-1));
    System.out.println(isPalindrome(-121));
    System.out.println(Integer.MAX_VALUE);
    System.out.println(isPalindrome(Integer.MAX_VALUE));

  }

  public static boolean isPalindrome(int num) throws Exception {

      if(num < 0){
        return false;
      }

      if(num >= 0 && num <= 9){
        return true;
      }

      int num2 = 0;
      int num1 = num;

      while(num > 0){
        int digit = num%10;
        num2 = num2*10 + digit;
        num = num/10;
      }

      if(num1 - num2 == 0){
        return true;
      }else{
        return false;
      }
  }

  // Time Complexity = O(totalNumberOfDigitInInputNumber)
  // Space Complexity = O(spaceInteger) ~ O(1)

}
