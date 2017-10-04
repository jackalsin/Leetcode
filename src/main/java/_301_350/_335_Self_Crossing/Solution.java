package _301_350._335_Self_Crossing;

/**
<<<<<<< HEAD
 * @author jacka
 * @version 1.0 on 10/3/2017.
 */
public class Solution {
  /**
   * We can perform an inductive referring:
   * First, we can easily found
   *  Case 1: 3 -> 0, 4 -> 1, 5 -> 2, 6 -> 3, 7 -> 4
   *  Then, consider 4,
   *  4 -> 0 (1 and 3 must be equal and 4 must be longer than or equals 2 - 0)
   *  4 -> 1 (covered in previous case)
   *  4 -> 2 (since 3 cannot be zero, impossible)
   *  4 -> 3 (directly connected, doesn't count)
   *  Thus, case 2:
   *    4 -> 0, 5 -> 1, 6 -> 2, 7 -> 3
   *
   *  Now, consider 5,
   *  5 -> 0  (only when 4 + 0 >= 2 && 5 + 1 >= 3 && 1 >= 3)
   *  5 -> 1  (covered in case 2)
   *  5 -> 2  (covered in case 1)
   *  5 -> 3  (since 4 cannot be zero, impossible)
   *  5 -> 4  (directly, connected, doesn't count)
   *  Thus, case 3,
   *    5 -> 0, 6 -> 1, 7 -> 2
   *
   *  Now, consider 6,
   *  6 -> 0  (if this happens, it will also cross 1)
   *  6 -> 1  (covered in case 3)
   *  6 -> 2  (covered in case 2)
   *  6 -> 3  (covered in case 1)
   *  6 -> 4  (since 4 cannot be zero, impossible)
   *  6 -> 5  (directly, connected, doesn't count)
   *
   *  So far, for a specific line, it can only be crossed by line 3, 4, 5 steps later ( take the
   *  example of 0), so we can implement the following solution.
   *
   *
   *  @param x
   * @return
   */
  public boolean isSelfCrossing(int[] x) {
    if (x == null) return false;
    for (int i = 3; i < x.length; ++i) {
      /* 3 -> 0, 4 -> 1, 5 -> 2 */
      if (i >= 3 && (x[i - 1] <= x[i - 3]) && (x[i] >= x[i - 2]))
        return true;
      if (i >= 4 && (x[i - 1] == x[i - 3]) && (x[i] + x[i - 4] >= x[i - 2]))
        return true;
      if (i >= 5 && (x[i - 1] >= (x[i - 3] - x[i - 5]) && x[i - 1] <= x[i - 3])
          && (x[i] >= (x[i - 2] - x[i - 4]) && x[i - 2] >= x[i - 4]))
        return true;
    }
    return false;
  }
}
