package _351_400._386_Lexicographical_Numbers;

import java.util.ArrayList;
import java.util.List;

public final class IterativeSolution implements Solution {
  @Override
  public List<Integer> lexicalOrder(int n) {
    final List<Integer> result = new ArrayList<>();
    int cur = 1;
    for (int i = 1; i <= n; i++) {
      result.add(cur);
      if (cur * 10 <= n) {
        cur *= 10;
      } else if (cur % 10 != 9 && cur + 1 <= n) {
        cur++;
      } else {
        // 1) cur 499 and n = 700
        // 2) cur 192 and n = 192 -> 2
        // 2) cur 120 and n = 120 -> 13
        // Explain:   192 因为超过进入此block，末尾是肯定要省略的，但是, 如果此时还是9，那么不断进位
        cur /= 10; // This remove the last digit, like backtracking
        while (cur % 10 == 9) { // the ultimate goal is to plus one, but if the last digit is one, we need carry, next number of 1999 is 2
          cur /= 10;
        }
        cur++; // actual plus one
      }
    }
    return result;
  }
}
