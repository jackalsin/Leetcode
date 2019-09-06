package interviews.linkedin._412_Fizz_Buzz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/5/2019
 */
public class SolutionI {
  private static final String FIZZ = "Fizz", BUZZ = "Buzz";

  public List<String> fizzBuzz(int n) {
    final List<String> result = new ArrayList<>();
    for (int i = 1; i <= n; ++i) {
      if (i % 3 == 0 && i % 5 == 0) {
        result.add(FIZZ + BUZZ);
      } else if (i % 3 == 0) {
        result.add(FIZZ);
      } else if (i % 5 == 0) {
        result.add(BUZZ);
      } else {
        result.add(String.valueOf(i));
      }
    }
    return result;
  }
}
