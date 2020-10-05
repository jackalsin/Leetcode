package _0001_0050._038_Count_and_Say;

/**
 * @author jacka
 * @version 1.0 on 2/17/2017.
 */
public class Solution {
  public String countAndSay(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException("n must be greater than 0, but now is " + n);
    } else if (n == 1) {
      return "1";
    } else {
      return countMNTimes("1", n);
    }
  }

  private static String countMNTimes(String m, int n) {
    if (n == 1) {
      return m;
    } else {
      StringBuilder result = new StringBuilder();
      char prev = 'a';
      int count = 1;
      for (int i = 0; i < m.length(); i++) {
        char curChar = m.charAt(i);
        if (i == m.length() - 1) {
          if (prev == curChar) {
            result.append(count + 1).append(prev);
          } else {
            result.append(count).append(prev).append(1).append(curChar);
          }
        } else { // not the last one.
          if (prev == curChar) {
            count++;
          } else {
            result.append(count).append(prev);
            prev = curChar;
            count = 1;
          }
        }
      }
      return countMNTimes(result.substring(2), n - 1);
    }
  }
}
