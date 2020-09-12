package _0851_0900._860_Lemonade_Change;

/**
 * @author jacka
 * @version 1.0 on 9/12/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean lemonadeChange(int[] bills) {
    int five = 0, ten = 0;
    for (final int b : bills) {
      if (b == 5) {
        five++;
      } else if (b == 10) {
        if (five == 0) return false;
        five--;
        ten++;
      } else if (b == 20) {
        if (five > 0 && ten > 0) {
          five--;
          ten--;
        } else if (five >= 3) {
          five -= 3;
        } else {
          return false;
        }
      } else {
        throw new IllegalArgumentException("Unsupported bill = " + b);
      }
    }
    return true;
  }
}
