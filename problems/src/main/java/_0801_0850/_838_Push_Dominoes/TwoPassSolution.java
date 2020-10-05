package _0801_0850._838_Push_Dominoes;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/3/2020
 */
public final class TwoPassSolution implements Solution {
  private static final char L = 'L', R = 'R', DOT = '.';

  public String pushDominoes(String dominoes) {
    /*
     * If you see 'R' and R > L, you have R....R, turn everything to 'R'.
     * If you see 'R' and R < L, you have L...R and you don't need to do anything.
     * If you see 'L' and L > R, you have L....L, turn everything to 'L'.
     * if you see 'L' and L < R, you have R....L, have to pointers from both sides, lo and hi, turn a[lo]='R' and
     *      a[hi] = 'L', increment lo, decrement hi, make sure you do nothing when lo=hi
     * Watch out for edge cases. Note i<=dominoes.length(), this is to deal with L.. Also note L and R are
     * initialized to -1, not 0.
     */
    int lastL = -1, lastR = -1;
    final char[] chars = dominoes.toCharArray();
    final int n = dominoes.length();
    for (int i = 0; i < n; ++i) {
      final char chr = chars[i];
      if (chr == L) {
        if (lastL < lastR) {
          // R ... L
          for (int left = lastR + 1, right = i - 1; left < right; ++left, --right) {
            chars[left] = R;
            chars[right] = L;
          }
        } else if (lastL >= lastR) {
          // if (lastL > lastR) : L ... L
          // if (lastL == lastR) : ... L
          if (lastL + 1 <= i - 1) Arrays.fill(chars, lastL + 1, i, L);
        }
        lastL = i;
      } else if (chr == R) {
        if (lastL < lastR) {
          // R ... R
          if (lastR + 1 <= i - 1) Arrays.fill(chars, lastR + 1, i, R);
        } else if (lastL > lastR) {
          // L ... R
          for (int left = lastL + 1, right = i - 1; left < right; ++left, --right) {
            chars[left] = L;
            chars[right] = R;
          }
        }
        lastR = i;
      } else if (i == n - 1 && chr == DOT && lastR > lastL) {
        // R ...
        if (lastR + 1 < n) {
          Arrays.fill(chars, lastR + 1, n, R);
        }
      }
    }
    return String.valueOf(chars);
  }
}
