package _0651_0700._659_Split_Array_into_Consecutive_Subsequences;

/**
 * Time complexity O (N), space complexity O(1)
 *
 * @author jacka
 * @version 1.0 on 12/29/2017.
 */
public final class SpaceO1Solution implements Solution {
  @Override
  public boolean isPossible(int[] nums) {
    int pre = Integer.MIN_VALUE, p1 = 0, p2 = 0, p3 = 0;
    int cur = 0, cnt = 0, c1 = 0, c2 = 0, c3 = 0;
    for (int i = 0; i < nums.length; pre = cur, p1 = c1, p2 = c2, p3 = c3) {
      for (cur = nums[i], cnt = 0; i < nums.length && cur == nums[i]; i++, cnt++) {
        ;
      }
      if (cur == pre + 1) {
        if (cnt < p1 + p2) {
//          System.out.println("Return statement 1");
          return false;
        }
        c1 = Math.max(cnt - p1 - p2 - p3, 0);
        c2 = p1;
        // c3 can be from p2, and p3, but may don't have so many cur to add.
        c3 = p2 + Math.min(p3, cnt - p1 - p2);
      } else { // unable to add to the previous constructed list
        if (p1 != 0 || p2 != 0) {
//          System.out.println("Return statement 2");
          return false;
        }
        c1 = cnt;
        c2 = 0;
        c3 = 0;
      }
    }
//    System.out.println("p1 = " + p1 + ", p2 = " + p2);
    return p1 == 0 && p2 == 0;
  }
}
