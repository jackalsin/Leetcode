package _0751_0800._780_Reaching_Points;

/**
 * @author jacka
 * @version 1.0 on 3/7/2018.
 */
public class Solution {
  public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    while (tx >= sx && ty >= sy) {
      if (sx == tx && ty == sy) {
        return true;
      }
      if (tx >= ty) {
        // check the testFailedCase() in the test.
        if (sy == ty) {
          return (tx - sx) % sy == 0;
        }
        tx %= ty;
      } else {
        if (sx == tx) {
          return (ty - sy) % sx == 0;
        }
        ty %= tx;
      }
    }
    return false;
  }
}
