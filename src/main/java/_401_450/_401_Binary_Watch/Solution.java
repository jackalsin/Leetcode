package _401_450._401_Binary_Watch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 11/12/2017.
 */
public class Solution {
  public List<String> readBinaryWatch(int num) {
    if (num < 0) return new ArrayList<>();
    final List<String> result = new ArrayList<>();
    for (int hr = 0; hr <= num; hr++ ) {
      final int min = num - hr;
      List<String> minResult = getMinuteResult(min);
      List<String> hrResult = getHourResult(hr);
      for (String minute : minResult) {
        for (String hour: hrResult) {
          result.add(hour + ":" + minute);
        }
      }
    }
    return result;
  }

  private List<String> getMinuteResult(int min) {
    List<String> result = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();
    getPermutation(combination, min, 6, 0, 0);
    for (int i : combination) {
      if (i < 10) {
        result.add("0" + i);
      } else if (i < 60 ) {
        result.add(String.valueOf(i));
      }
    }
    return result;
  }

  private List<String> getHourResult(int min) {
    List<String> result = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();
    getPermutation(combination, min, 4, 0, 0);
    for (int i : combination) {
      if (i < 12) {
        result.add(String.valueOf(i));
      }
    }
    return result;
  }

  private void getPermutation(final List<Integer> result,
                              int candidates, final int max, final int start, int curSum ) {
    if (start > max) {
      return;
    } else if (candidates == 0) {
      result.add(curSum);
    } else {
      for (int i = start; i < max; i++) {
        getPermutation(result, candidates - 1, max, i + 1, curSum + (1 << i));
      }
    }
  }
}
