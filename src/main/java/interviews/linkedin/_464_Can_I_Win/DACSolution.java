package interviews.linkedin._464_Can_I_Win;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
public class DACSolution {
  //https://discuss.leetcode.com/topic/68896/java-solution-using-hashmap-with-detailed-explanation
  private Boolean[] win;
  int choosen = 0;

  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    if (desiredTotal == 0) {
      return true;
    }
    if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
      return false;
    }
    win = new Boolean[1 << maxChoosableInteger];
    return canWin(maxChoosableInteger, desiredTotal, 0);
  }

  private boolean canWin(int n, int total, int now) {
    if (win[choosen] != null) {
      return win[choosen];
    }
    if (now >= total) {
      win[choosen] = false;
      return false;
    }
    for (int i = 1; i <= n; i++) {
      int bit = 1 << (i - 1);
      if ((choosen & bit) == 0) {
        choosen ^= bit;
        boolean ulose = !canWin(n, total, now + i);
        choosen ^= bit;

        if (ulose) {
          win[choosen] = true;
          return true;
        }
      }
    }
    win[choosen] = false;
    return false;
  }
}
