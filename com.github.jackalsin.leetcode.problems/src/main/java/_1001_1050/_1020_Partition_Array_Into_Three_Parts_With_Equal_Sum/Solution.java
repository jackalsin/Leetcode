package _1001_1050._1020_Partition_Array_Into_Three_Parts_With_Equal_Sum;

public class Solution {

  public boolean canThreePartsEqualSum(int[] A) {
    final int sum = getSum(A);
    if (sum % 3 != 0) {
      return false;
    }
    final int target = sum / 3;
    int curSum = 0, found = 0;
    for (int a : A) {
      curSum += a;
      if (curSum == target) {
        found++;
        curSum = 0;
      }
      if (found >= 3) {
        return true;
      }
    }
    return false;
  }


  private static int getSum(final int[] a) {
    int sum = 0;
    for (int i : a) {
      sum += i;
    }
    return sum;
  }
}
