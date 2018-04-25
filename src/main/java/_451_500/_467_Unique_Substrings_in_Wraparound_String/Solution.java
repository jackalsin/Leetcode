package _451_500._467_Unique_Substrings_in_Wraparound_String;

public class Solution {

  /**
   * 81 / 81 test cases passed.
   * Status: Accepted
   * Runtime: 27 ms
   * <p>
   * Time Complexity: O(N)
   * Space Complexity: O(1)
   * <p>
   * Reference https://leetcode.com/problems/unique-substrings-in-wraparound-string/discuss/95439/Concise-Java-solution-using-DP
   *
   * @param p
   * @return
   */
  public int findSubstringInWraproundString(String p) {
    final int[] maxContinuousLength = new int[26];
    if (p == null || p.length() == 0) {
      return 0;
    }

    maxContinuousLength[p.charAt(0) - 'a'] = 1;
    int maxContinuous = 1;
    for (int i = 1; i < p.length(); i++) {
      if ((p.charAt(i) == p.charAt(i - 1) + 1) || (p.charAt(i) == p.charAt(i - 1) - 25)) {
        maxContinuous++;
      } else {
        maxContinuous = 1;
      }
      final int index = p.charAt(i) - 'a';
      maxContinuousLength[index] = Math.max(maxContinuousLength[index], maxContinuous);
    }

    int res = 0;
    for (int i : maxContinuousLength) {
      res += i;
    }
    return res;
  }
}
