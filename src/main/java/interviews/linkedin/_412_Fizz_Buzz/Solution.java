package interviews.linkedin._412_Fizz_Buzz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/15/18
 */
public class Solution {
  private static final String FIZZ = "Fizz", BUZZ = "Buzz";

  public List<String> fizzBuzz(int n) {
    final List<String> result = new ArrayList<>();
    for (int i = 1; i <= n; ++i) {
      final StringBuilder sb = new StringBuilder();
      if (i % 3 == 0) {
        sb.append(FIZZ);
      }
      if (i % 5 == 0) {
        sb.append(BUZZ);
      }
      result.add(sb.length() == 0 ? String.valueOf(i) : sb.toString());
    }
    return result;
  }
}
