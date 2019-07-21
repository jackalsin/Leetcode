package _0401_0450._412_Fizz_Buzz;

import java.util.ArrayList;
import java.util.List;

public final class SolutionI implements Solution {
  public List<String> fizzBuzz(int n) {
    final List<String> result = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      final StringBuilder sb = new StringBuilder();
      if (i % 3 == 0) {
        sb.append("Fizz");
      }
      if (i % 5 == 0) {
        sb.append("Buzz");
      }
      result.add(sb.length() == 0 ? String.valueOf(i) : sb.toString());
    }
    return result;
  }
}
