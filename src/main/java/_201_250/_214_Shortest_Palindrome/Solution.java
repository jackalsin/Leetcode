package _201_250._214_Shortest_Palindrome;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/11/2017.
 */
public class Solution {

  public String shortestPalindrome(String s) {
    if (s == null || s.isEmpty())  return "";
    int prevMid = (s.length() - 1) / 2;
    while (true) {
      int[] palindromeIndexOdd = getPalindrome(s, prevMid, prevMid);
      int[] palindromeIndexEven = getPalindrome(s, prevMid, prevMid + 1);
      int[] palindromeIndex = null;
      if (palindromeIndexOdd[0] < 0 && palindromeIndexEven[0] < 0) {
        palindromeIndex = palindromeIndexOdd[1] > palindromeIndexEven[1] ? palindromeIndexOdd :
            palindromeIndexEven;
      } else if (palindromeIndexOdd[0] < 0) {
        palindromeIndex = palindromeIndexOdd;
      } else if (palindromeIndexEven[0] < 0) {
        palindromeIndex = palindromeIndexEven;
      }

      if (palindromeIndex == null) { // undone
        prevMid--;
      } else {
        return new StringBuilder().append(s.substring(palindromeIndex[1])).reverse().append(s).toString();
      }
    }
  }

  static int[] getPalindrome(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return new int[]{left, right};
  }

}
