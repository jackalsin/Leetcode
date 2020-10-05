package _0901_0950._904_Fruit_Into_Baskets;

public final class OnePassSolution implements Solution {
  public int totalFruit(int[] tree) {
    int max = 0, cur = 0, count_b = 0, a = -1, b = -1;
    for (int t : tree) {
      if (t == b) {
        count_b += 1;
        cur++;
      } else if (t == a) {
        cur++;
        count_b = 1;
        a = b;
        b = t;
      } else {
        cur = count_b + 1;
        count_b = 1;
        a = b;
        b = t;
      }

      max = Math.max(max, cur);
    }
    return max;
  }
}
