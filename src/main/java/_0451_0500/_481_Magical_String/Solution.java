package _0451_0500._481_Magical_String;

/**
 * @author jacka
 * @version 1.0 on 11/30/2017.
 */
public class Solution {
  /**
   * 13 ms Solution: AC
   */
  public int magicalString(int n) {
    if (n <= 0) {
      return 0;
    }
    if (n <= 3) {
      return 1;
    }
    // generate the string
    int ptr = 2, next = 3, curVal = 1, count = 1;
    final int[] s = new int[n];
    s[0] = 1;
    s[1] = 2;
    s[2] = 2;
    while (next < n) { // generate
      if (s[ptr] == 1) {
        s[next++] = curVal;
      } else {
        s[next++] = curVal;
        if (next < n) {
          s[next++] = curVal;
          if (curVal == 1) {
            count++;
          }
        }
      }
      if (curVal == 1) {
        count++;
      }
      ptr++;
      curVal = curVal == 1 ? 2 : 1;
    }

//    System.out.println(Arrays.toString(s));
    return count;
  }
}
