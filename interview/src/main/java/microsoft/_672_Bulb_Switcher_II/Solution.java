package microsoft._672_Bulb_Switcher_II;

/**
 *
 */
public class Solution {
  /**
   * @param n number of bulbs
   * @param m
   * @return
   */
  public int flipLights(int n, int m) {
    assert n >= 0 && m >= 0;
    n = Math.min(n, 3);
    if (m == 0) {
      return 1;
    }
    if (m == 1) {
      /*
       * 1 1 1 At first
       * 0 0 0
       * 1 0 1
       * 0 1 0
       * 0 1 1
       */
      if (n == 1) {
        return 2;
      } else if (n == 2) {
        return 3;
      } else if (n == 3) {
        return 4;
      }
    } else if (m == 2) {
      if (n == 1) {
        return 2;
      } else if (n == 2) {
        return 4;
      } else if (n == 3) {
        return 7;
      }
    } else {
      if (n == 1) {
        return 2;
      } else if (n == 2) {
        return 4;
      } else if (n == 3) {
        return 8;
      }
    }

    throw new IllegalStateException("You shouldn't be here");
  }
}
