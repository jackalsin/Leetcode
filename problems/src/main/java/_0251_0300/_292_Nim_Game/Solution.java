package _0251_0300._292_Nim_Game;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/6/2017.
 */
public class Solution {
  public boolean canWinNim(int n) {
    return o1Solution(n);
//    return TLESolution(n);

  }

  private static boolean o1Solution(int n) {
    return n != 0 && (n % 4 != 0);
  }

  private static boolean TLESolution(int n) {
    if (n == 0) return false;
    if (n <= 3) return true;
    final boolean[] canWin = new boolean[n + 1];
    canWin[1] = true;
    canWin[2] = true;
    canWin[3] = true;
    for (int i = 4; i <= n; ++i) {
      canWin[i] = !canWin[i - 1] || !canWin[i - 2] || !canWin[i - 3];
    }
    return canWin[n];
  }
}
