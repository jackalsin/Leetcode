package _0201_0250._214_Shortest_Palindrome;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/11/2017.
 */
public class Solution {

  public String shortestPalindrome(String s) {
//    return bruteForceSolution(s);
    return kmpSolution(s);
  }


  //------------------------ kmp solution ----------------------------
  private String kmpSolution(String s) {
    String temp = new StringBuilder().append(s).append("#").append(new StringBuilder().append(s)
        .reverse()).toString();
    int[] commonPrefixPostfix = genTable(temp);
    int largestCommonPrePostfix = commonPrefixPostfix[temp.length() - 1];
    return new StringBuilder()
        .append(new StringBuilder().append(s.substring(largestCommonPrePostfix)).reverse())
        .append(s).toString();
  }

  int[] genTable(String s) {
    int[] table = new int[s.length()];

    for(int prev = 0, post = 1; post < s.length(); post++) {
      if (s.charAt(prev) == s.charAt(post)) {
        table[post] = table[post - 1] + 1;
        prev++;
      } else {

        //by assigning index to table[i-1], we will shorten the match string length, and jump to the
        //prefix part that we used to match postfix ended at i - 1
        prev = table[post-1];

        while(prev > 0 && s.charAt(prev) != s.charAt(post)){
          //we will try to shorten the match string length until we revert to the beginning of match (index 1)
          prev = table[prev-1];
        }

        //when we are here may either found a match char or we reach the boundary and still no luck
        //so we need check char match
        if(s.charAt(prev) == s.charAt(post)){
          //if match, then extend one char
          prev ++ ;
        }
        table[post] = prev;
      }
    }
    return table;
  }

  //------------------------ brute force solution --------------------
  private String bruteForceSolution(String s) {
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
