package _051_100._091_Decode_Ways;

/**
 * @author jacka
 * @version 1.0 on 5/31/2017.
 */
public class Solution {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int[] nums = new int[s.length()];
    nums[0] = s.charAt(0) == '0' ? 0: 1;
    for(int i = 1; i < s.length(); i++ ) {
      char curChar = s.charAt(i);
      if (curChar > '0' && curChar <= '9') {
        nums[i]++;
      }
      int combinedTwoDigits = (s.charAt(i - 1) - '0') * 10 + curChar - '0';
      if (combinedTwoDigits > 0 && combinedTwoDigits <= 26) {
        nums[i]++;
      }
    }
    return nums[s.length() - 1];
  }
}
