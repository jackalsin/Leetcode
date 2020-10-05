package linkedin._319_Bulb_Switcher;

/**
 * @author jacka
 * @version 1.0 on 9/2/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public int bulbSwitch(int n) {
    if (n <= 0) {
      return 0;
    }
    int count = 0;
    for (int i = 1; (long) i * i <= n; ++i) {
      count++;
    }
    return count;
  }
}
