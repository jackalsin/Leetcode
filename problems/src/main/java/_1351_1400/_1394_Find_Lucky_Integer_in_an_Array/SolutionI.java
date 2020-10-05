package _1351_1400._1394_Find_Lucky_Integer_in_an_Array;

/**
 * @author jacka
 * @version 1.0 on 3/28/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int findLucky(int[] arr) {
    if (arr == null || arr.length == 0) {
      return 0;
    }
    final int[] count = new int[arr.length + 1];
    for (int a : arr) {
      if (a <= arr.length) {
        count[a]++;
      }
    }
    for (int i = arr.length; i > 0; --i) {
      if (count[i] == i) {
        return i;
      }
    }
    return -1;
  }
}
