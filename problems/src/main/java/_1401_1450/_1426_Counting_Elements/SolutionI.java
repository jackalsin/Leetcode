package _1401_1450._1426_Counting_Elements;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 5/3/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int countElements(int[] arr) {
    Arrays.sort(arr);
    int count = 0;
    for (int i = 0, j = 0; i <= j && j < arr.length; i++) {
      while (j < arr.length && arr[i] == arr[j]) {
        j++;
      }
      if (j == arr.length) break;
      if (arr[i] == arr[j] - 1) {
        count++;
      }
    }
    return count;
  }
}
