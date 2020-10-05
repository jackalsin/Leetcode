package _0401_0450._412_Fizz_Buzz;

import java.util.ArrayList;
import java.util.List;

public final class SolutionII implements Solution {
  private static final String FIZZ = "Fizz",
      BUZZ = "Buzz", FIZZ_BUZZ = "FizzBuzz";

  public List<String> fizzBuzz(int n) {
    final List<String> result = new ArrayList<>();
    for (int i = 1, fizz = 1, buzz = 1; i <= n; i++, fizz++, buzz++) {
      if (fizz == 3 && buzz == 5) {
        result.add(FIZZ_BUZZ);
        fizz = 0;
        buzz = 0;
      } else if (fizz == 3) {
        result.add(FIZZ);
        fizz = 0;
      } else if (buzz == 5) {
        result.add(BUZZ);
        buzz = 0;
      } else {
        result.add(String.valueOf(i));
      }
    }
    return result;
  }
}
