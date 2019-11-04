package interviews.oracle._032_Longest_Valid_Parentheses;

/**
 * @author jacka
 * @version 1.0 on 11/3/2019
 */
public final class DpSolution implements Solution {
  @Override
  public int longestValidParentheses(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    // longestEndHere[i + 1] means longest valid string end at i (inclusive)
    final int n = s.length();
    int max = 0;
    final int[] longestEndHere = new int[n + 1];
    for (int i = 1; i < n; ++i) {
      final char chr = s.charAt(i);
      if (chr == '(') { // if it's '(', cannot be the end
        longestEndHere[i + 1] = 0;
      } else {
        if (s.charAt(i - 1) == '(') { // [valid str]()
          longestEndHere[i + 1] = longestEndHere[i - 1] + 2;
        }
        if (i - longestEndHere[i] - 1 >= 0 && s.charAt(i - longestEndHere[i] - 1) == '(') {
          // [valid str] '('[valid str] ')'
          longestEndHere[i + 1] = Math.max(longestEndHere[i] + 2 + longestEndHere[i - longestEndHere[i] - 1],
              longestEndHere[i + 1]);
        }
      }
      max = Math.max(max, longestEndHere[i + 1]);
    }
//    System.out.println(Arrays.toString(longestEndHere));
    return max;
  }
}
