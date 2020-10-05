package _1151_1200._1170_Compare_Strings_by_Frequency_of_the_Smallest_Character;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 10/20/2019
 */
public final class SolutionI implements Solution {
  private static final int N = 26;

  public int[] numSmallerByFrequency(String[] queries, String[] words) {
    final int[] freqCache = getFrequentCache(words);
    Arrays.sort(freqCache);
    final int[] result = new int[queries.length];
    for (int i = 0; i < queries.length; ++i) {
      final int freq = getFrequent(queries[i]),
          firstIndex = searchFirstGreater(freqCache, freq);
      final int count = words.length - 1 - firstIndex + 1;
      result[i] = count;
    }
    return result;
  }

  private static int searchFirstGreater(final int[] nums, final int target) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      final int mid = left + (right - left) / 2;
      if (nums[mid] > target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    if (nums[left] > target) {
      return left;
    }
    return nums.length;
  }

  private static int[] getFrequentCache(final String[] words) {
    final int[] result = new int[words.length];
    for (int i = 0; i < words.length; ++i) {
      result[i] = getFrequent(words[i]);
    }
    return result;
  }

  private static int getFrequent(final String word) {
    final int[] count = new int[N];
    for (char chr : word.toCharArray()) {
      count[chr - 'a']++;
    }
    for (int i = 0; i < N; i++) {
      if (count[i] != 0) {
        return count[i];
      }
    }
    throw new IllegalStateException();
  }
}
