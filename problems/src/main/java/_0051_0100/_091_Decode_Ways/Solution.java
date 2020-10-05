package _0051_0100._091_Decode_Ways;

/**
 * @author jacka
 * @version 1.0 on 5/31/2017.
 */
public class Solution {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int[] nums = new int[s.length() + 1];
    nums[0] = 1;
    nums[1] = s.charAt(0) == '0' ? 0 : 1;
    for (int i = 1; i < s.length(); i++) {
      char curChar = s.charAt(i);
      if (curChar > '0' && curChar <= '9') {
        nums[i + 1] += nums[i];
      }
      int combinedTwoDigits = (s.charAt(i - 1) - '0') * 10 + curChar - '0';
      if (combinedTwoDigits >= 10 && combinedTwoDigits <= 26) {
        nums[i + 1] += nums[i - 1];
      }
    }
    return nums[s.length()];
  }


//  public int numDecodings(String s) {
//    int n = s.length();
//    if (n == 0) return 0;
//
//    int[] memo = new int[n+1];
//    memo[n]  = 1;
//    memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;
//
//    for (int i = n - 2; i >= 0; i--)
//      if (s.charAt(i) == '0') continue;
//      else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];
//    System.out.println(Arrays.toString(memo));
//    return memo[0];
//  }
}
