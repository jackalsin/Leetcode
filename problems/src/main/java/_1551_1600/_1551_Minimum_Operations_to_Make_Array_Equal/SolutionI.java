package _1551_1600._1551_Minimum_Operations_to_Make_Array_Equal;

/**
 * @author jacka
 * @version 1.0 on 10/24/2020
 */
public class SolutionI implements Solution {
  @Override
  public int minOperations(int n) {
    final int halfLen = n / 2;
    return ((n - 1) + n - (1 + (halfLen - 1) * 2)) * halfLen / 2;
  }
}
