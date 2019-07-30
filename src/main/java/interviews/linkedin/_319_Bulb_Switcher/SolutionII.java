package interviews.linkedin._319_Bulb_Switcher;

public final class SolutionII implements Solution {
  public int bulbSwitch(int n) {
    if (n <= 0) {
      return 0;
    }
    int res = 0;
    for (int i = 1; i * i <= n; i++) {
      res++;
    }
    return res;
  }
}
