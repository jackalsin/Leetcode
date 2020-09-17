package _0901_0950._902_Numbers_At_Most_N_Given_Digit_Set;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/16/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int atMostNGivenDigitSet(String[] candidates, final int val) {
    if (val == 0) return 0;
    int result = 0;
    final String valStr = String.valueOf(val);
    final Map<Integer, Integer> candidateToCountSmallerThanSelf = getCandidateToCountSmallerThanSelf(candidates);
    final Set<Integer> candidateSet = getCandidateSet(candidates);
    final int valLen = valStr.length(), candidatesLen = candidates.length;
    // if val = 1234
    // section 1: Find x, xx, xxx
    for (int i = 1; i < valLen; ++i) {
      result += Math.pow(candidatesLen, i);
    }
    // section 2: trying to find the 1xxx, 12xx, 123X
    // we do the count for 1[01]xx -> candidateSize ^ 2
    // if we are not able to `2`, we don't need go on.
    // if we can finish the for loop, val must be 1234, so return result + 1.
    for (int i = 0; i < valLen; ++i) {
      final int curValDigit = valStr.charAt(i) - '0';
      final int smallerCount = candidateToCountSmallerThanSelf.get(curValDigit);
      result += smallerCount * Math.pow(candidatesLen, valLen - i - 1);
      if (!candidateSet.contains(curValDigit)) return result;
    }
    return result + 1;
  }

  private Set<Integer> getCandidateSet(final String[] candidates) {
    final Set<Integer> result = new HashSet<>();
    for (final String candidateStr : candidates) {
      result.add(candidateStr.charAt(0) - '0');
    }
    return result;
  }

  private static Map<Integer, Integer> getCandidateToCountSmallerThanSelf(final String[] candidates) {
    Arrays.sort(candidates);
    final Map<Integer, Integer> result = new HashMap<>();
    for (int i = 0, k = 0, count = 0; i < 10; ++i) {
      result.put(i, count);
      if (k < candidates.length && Integer.parseInt(candidates[k]) == i) {
        k++;
        count++;
      }
    }
    return result;
  }

}
