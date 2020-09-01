package _0801_0850._810_Chalkboard_XOR_Game;

/**
 * @author jacka
 * @version 1.0 on 8/31/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean xorGame(int[] nums) {
    /*
    1) if xor == 0 Alice wins
    2) if nums.length % 2 == 0:
        there are at least 2 different numbers,
        pick the one not equals to the current `xor`
    3) if nums.length % 2 != 0:
         if Alice pick number equals the current `xor`, Bob wins
         if not, Bob will have the choice of 2)
    */
    int xor = 0;
    for (int n : nums) {
      xor ^= n;
    }
    return xor == 0 || nums.length % 2 == 0;
  }
}
