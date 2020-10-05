package _0251_0300._274_H_Index;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/2/2017.
 */
public class Solution {
  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    if (citations.length == 0) return 0;
    int n = citations.length;
    for (int h = n; h >= 1; h--) {
      if (citations[n - h] >= h && (n == h || citations[n - h - 1] <= h)) {
        return h;
      }
    }
    return 0;
  }
}
