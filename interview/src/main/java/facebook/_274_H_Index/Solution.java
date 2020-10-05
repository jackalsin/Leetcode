package facebook._274_H_Index;

public class Solution {
  public int hIndex(int[] citations) {
    final int n = citations.length;
    final int[] buckets = new int[citations.length + 1];
    for (int c : citations) {
      if (c >= n) buckets[n]++;
      else {
        buckets[c]++;
      }
    }

    int counts = 0;
    for (int h = buckets.length - 1; h >= 0; h--) {
      counts += buckets[h];
      if (counts >= h) {
        return h;
      }
    }

    throw new IllegalStateException("You shouldn't be here");
  }
}
