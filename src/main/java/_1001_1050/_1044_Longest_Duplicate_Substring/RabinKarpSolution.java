package _1001_1050._1044_Longest_Duplicate_Substring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 12/25/2019
 */
public final class RabinKarpSolution implements Solution {
  private static final int N = 26, MAX_S_LENGTH = (int) 1E5, PRIME = (int) (1E9 + 7);
  private static final long[] POWERS = getPowers(MAX_S_LENGTH);

  private static long[] getPowers(final int len) {
    final long[] result = new long[len];
    result[0] = 1;
    for (int i = 1; i < len; ++i) {
      result[i] = result[i - 1] * N % PRIME;
    }
//    System.out.println(Arrays.toString(result));
    return result;
  }

  public String longestDupSubstring(String s) {
    if (s == null || s.isEmpty()) {
      return "";
    }
    int left = 0, right = s.length() - 1;
    final char[] chars = s.toCharArray();
    int maxLeft = 0;
    while (left < right) {
      final int mid = left + (right - left + 1) / 2;
      final int maxLeftCandidate = isValid(chars, mid);
//      System.out.println("len = " + mid + ", maxLeftCandidate = " + maxLeftCandidate);
      if (maxLeftCandidate != -1) {
        left = mid;
        maxLeft = maxLeftCandidate;
      } else {
        right = mid - 1;
      }
    }
    return s.substring(maxLeft, maxLeft + left);
  }

  private static int isValid(final char[] chars, final int len) {
    // computer the hash a[0, len)
    long hash = 0;
    for (int i = 0; i < len; ++i) {
      hash = (hash * N + chars[i] - 'a') % PRIME;
    }
    final Map<Long, List<Integer>> seen = new HashMap<>();
    seen.computeIfAbsent(hash, h -> new ArrayList<>()).add(0);
    for (int i = len; i < chars.length; i++) {
      hash = (hash * N - (chars[i - len] - 'a') * (long) POWERS[len] % PRIME + PRIME) % PRIME;
      hash = (hash + chars[i] - 'a') % PRIME;
      if (seen.containsKey(hash)) {
        for (int start : seen.get(hash)) {
          if (isEquals(chars, start, i - len + 1, len)) {
            return i - len + 1;
          }
        }
      }
      seen.computeIfAbsent(hash, h -> new ArrayList<>()).add(i - len + 1);
    }
    return -1;
  }

  private static boolean isEquals(final char[] chars, final int start1, final int start2, int len) {
    for (int i = 0; i < len; ++i) {
      if (chars[start1 + i] == chars[start2 + i]) continue;
      return false;
    }
    return true;
  }
}
