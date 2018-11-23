package _0601_0650._650_2_Keys_Keyboard;

/**
 * @author jacka
 * @version 1.0 on 10/30/2017.
 */
public final class SolutionII implements Solution {

  public int minSteps(int n) { // TODO: Redo it
    int ans = 0, d = 2;
    while (n > 1) {
      if (n % d == 0) {
        ans += d;
        n /= d;
      }
      d++;
    }
    return ans;
  }

}
