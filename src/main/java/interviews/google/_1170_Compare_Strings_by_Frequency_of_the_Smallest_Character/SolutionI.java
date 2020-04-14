package interviews.google._1170_Compare_Strings_by_Frequency_of_the_Smallest_Character;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 4/13/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] numSmallerByFrequency(String[] queries, String[] words) {
    final int len = words.length;
    final int[] freqs = new int[len];
    for (int i = 0; i < words.length; ++i) {
      freqs[i] = getMinFreq(words[i]);
    }
    Arrays.sort(freqs);
//    System.out.println(Arrays.toString(freqs));
    final int[] result = new int[queries.length];
    for (int i = 0; i < queries.length; ++i) {
      final int c = getMinFreq(queries[i]);
      final int r = firstGreaterThan(freqs, c);
      result[i] = freqs.length - r;
    }
    return result;
  }

  private static int firstGreaterThan(final int[] nums, final int target) {
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

  private static int getMinFreq(final String word) {
    final int[] count = new int[26];
    for (final char chr : word.toCharArray()) {
      count[chr - 'a']++;
    }
    int min = word.length();
    for (int i = 0; i < 26; ++i) {
      if (count[i] == 0) continue;
      return count[i];
    }
    throw new IllegalArgumentException("Cannot be empty.");
  }
}
