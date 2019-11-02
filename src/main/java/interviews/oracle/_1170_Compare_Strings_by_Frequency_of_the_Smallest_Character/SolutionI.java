package interviews.oracle._1170_Compare_Strings_by_Frequency_of_the_Smallest_Character;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 11/2/2019
 */
public final class SolutionI implements Solution {
  private static final int N = 26;

  public int[] numSmallerByFrequency(String[] queries, String[] words) {
    final int[] smallFrequency = getSmallestCharacterFreq(words), result = new int[queries.length];
    Arrays.sort(smallFrequency);
    for (int i = 0; i < queries.length; ++i) {
      final int freq = getSmallestCharacterFreq(queries[i]),
          index = binarySearch(smallFrequency, freq);
      result[i] = words.length - index;
    }
    return result;
  }

  /**
   * First occur
   *
   * @param nums
   * @param target
   * @return
   */
  private static int binarySearch(final int[] nums, final int target) {
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

  private int[] getSmallestCharacterFreq(final String[] words) {
    final int[] res = new int[words.length];
    for (int i = 0; i < words.length; ++i) {
      res[i] = getSmallestCharacterFreq(words[i]);
    }
    return res;
  }

  private static int getSmallestCharacterFreq(final String word) {
    char minChar = 'z';
    int minCount = 0;
    for (final char chr : word.toCharArray()) {
      if (chr < minChar) {
        minChar = chr;
        minCount = 1;
      } else if (chr == minChar) {
        minCount++;
      }
    }
    return minCount;
  }
}
