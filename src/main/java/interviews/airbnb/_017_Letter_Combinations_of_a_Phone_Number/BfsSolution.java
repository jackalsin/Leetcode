package interviews.airbnb._017_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 1/21/2019.
 */
public final class BfsSolution implements Solution {

  private static final String[][] MAP = {
      {},
      {},
      {"a", "b", "c"},
      {"d", "e", "f"},
      {"g", "h", "i"},
      {"j", "k", "l"},
      {"m", "n", "o"},
      {"p", "q", "r", "s"},
      {"t", "u", "v"},
      {"w", "x", "y", "z"},
  };

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return result;
    }
    result.add("");
    for (char chr : digits.toCharArray()) {
      final int i = chr - '0';
      final List<String> nextResult = new ArrayList<>();
      for (String child : result) {
        for (String add : MAP[i]) {
          nextResult.add(child + add);
        }
      }
      result = nextResult;
    }
    return result;
  }
}
