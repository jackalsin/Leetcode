package _351_400._370_Range_Addition;

public class Solution {
  public int[] getModifiedArray(int length, int[][] updates) {
//    return naiveSolution(length, updates);
    return betterSolution(length, updates);
  }

  private int[] betterSolution(int length, int[][] updates) {
    final int[] result = new int[length];
    for (final int[] update : updates) {
      final int value = update[2];
      final int startIndex = update[0];
      final int endIndex = update[1];
      result[startIndex] += value;
      if (endIndex < length - 1) {
        result[endIndex + 1] -= value;
      }
    }

    int sum = 0;
    for (int i = 0; i < length; ++i) {
      sum += result[i];
      result[i] = sum;
    }

    return result;
  }

  private int[] naiveSolution(int length, int[][] updates) {
    final int[] result = new int[length];
    for (int[] update : updates) {
      for (int startIndex = update[0]; startIndex <= update[1]; startIndex++) {
        result[startIndex] += update[2];
      }
    }
    return result;
  }
}
