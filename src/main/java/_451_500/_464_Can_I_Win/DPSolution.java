package _451_500._464_Can_I_Win;

/**
 * @author jacka
 * @version 1.0 on 10/14/2017.
 */
public class DPSolution implements Solution {
  @Override
  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    /* 这他妈是错误的示范 */
    if (desiredTotal <= maxChoosableInteger) {
      return true;
    }
    return desiredTotal % (maxChoosableInteger + 1) != 0;
  }

}
