package _1151_1200._1170_Compare_Strings_by_Frequency_of_the_Smallest_Character;

/**
 * @author jacka
 * @version 1.0 on 10/20/2019
 */
public final class SolutionII implements Solution {
  private static final int N = 26, MAX_WORD_LEN = 10;

  public int[] numSmallerByFrequency(String[] queries, String[] words) {
    /* count of Frequency of smallest char, freqCount[freq] = count means how many count of this frq */
    final int[] freqCount = new int[MAX_WORD_LEN + 1];
    for (int i = 0; i < words.length; i++) {
      final int f = getF(words[i]);
      freqCount[f]++;
    }
//    System.out.println(Arrays.toString(freqCount));

    final int[] accumulateFreq = new int[MAX_WORD_LEN + 1];
//    accumulateFreq[MAX_WORD_LEN] = freqCount[MAX_WORD_LEN];
    for (int i = MAX_WORD_LEN - 1; i >= 0; --i) {
      accumulateFreq[i] = freqCount[i + 1] + accumulateFreq[i + 1];
    }
//    System.out.println(Arrays.toString(accumulateFreq));

    final int[] result = new int[queries.length];
    for (int i = 0; i < queries.length; ++i) {
      final int f = getF(queries[i]);
      result[i] = accumulateFreq[f];
    }
//    System.out.println(Arrays.toString(result));
    return result;
  }

  private int getF(final String word) {
    final int[] count = new int[N];
    for (char chr : word.toCharArray()) {
      count[chr - 'a']++;
    }
    for (int i = 0; i < N; ++i) {
      if (count[i] == 0) continue;
      return count[i];
    }
    throw new IllegalStateException();
  }
}
