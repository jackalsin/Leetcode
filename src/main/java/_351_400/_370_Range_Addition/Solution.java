package _351_400._370_Range_Addition;

public class Solution {
  public int[] getModifiedArray(int length, int[][] updates) {
    final int[] result = new int[length];

    for (int[] update : updates) {
      for (int startIndex = update[0]; startIndex <= update[1]; startIndex++) {
        result[startIndex] += update[2];
      }
    }
    return result;
  }
}
