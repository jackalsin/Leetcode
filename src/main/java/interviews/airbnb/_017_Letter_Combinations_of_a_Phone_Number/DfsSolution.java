package interviews.airbnb._017_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 1/21/2019.
 */
public class DfsSolution implements Solution {

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
    final List<String> result = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return result;
    }
    dfs(result, "", digits, 0);
    return result;
  }

  private static void dfs(List<String> result, String curPath, final String digits, int i) {
    if (i == digits.length()) {
      result.add(curPath);
      return;
    }
    final int index = digits.charAt(i) - '0';
    for (String add : MAP[index]) {
      dfs(result, curPath + add, digits, i + 1);
    }
  }
}
