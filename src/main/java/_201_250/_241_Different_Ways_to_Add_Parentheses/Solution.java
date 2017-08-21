package _201_250._241_Different_Ways_to_Add_Parentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * uncached
 * @author jacka
 * @version 1.0 on 8/20/2017.
 */
public class Solution {

  private Map<String, List<Integer>> cache = new HashMap<>();
  public List<Integer> diffWaysToCompute(String input) {
    return diffWaysToCompute(input, 0, input.length() - 1);
  }

  /**
   *
   * @param input
   * @param start inclusive
   * @param end   inclusive
   * @return
   */
  private List<Integer> diffWaysToCompute(String input, int start, int end) {
    List<Integer> result = new ArrayList<>();
    String subString = input.substring(start, end + 1);
    if (cache.containsKey(subString)) {
      return cache.get(subString);
    }
    for (int i = start; i <= end; ++i) {
      char chr = input.charAt(i);
      if (chr == '*' || chr == '+' || chr == '-') {
        List<Integer> left = diffWaysToCompute(input, start, i - 1);
        List<Integer> right = diffWaysToCompute(input, i + 1, end);
        for (int leftChild : left) {
          for(int rightChild: right) {
            switch (chr) {
              case '*':
                result.add(leftChild * rightChild);
                break;
              case '-':
                result.add(leftChild - rightChild);
                break;
              case '+':
                result.add(leftChild + rightChild);
                break;
            }
          }
        } // end of for loop left child
      }
    }
    if (result.size() == 0) {
      result.add(Integer.valueOf(input.substring(start, end + 1)));
    }
    cache.put(subString, result);
    return result;
  }
}

