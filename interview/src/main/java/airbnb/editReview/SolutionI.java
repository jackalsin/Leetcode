package airbnb.editReview;

import java.util.Arrays;
import java.util.Map;

/**
 * 这个solution用了KMP
 * 能够handle key overlap, 比如 San, San Jose
 * 但无法handle "cap" and "ape" 这个情况
 */
public final class SolutionI implements Solution {
  // example: [business]{Airbnb}
  private static final String FORMAT = "[%s]{%s}";

  @Override
  public String getEditedReview(Map<String, String> wordsToType, String line) {
    final String[] isBold = new String[line.length()];
    Arrays.fill(isBold, "");
    for (final Map.Entry<String, String> e : wordsToType.entrySet()) {
      final String word = e.getKey();
      substring2(line, word, isBold);
    }
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < line.length(); i++) {
      if (isBold[i].equals("")) {
        sb.append(line.charAt(i));
      } else {
        final String labelKey = isBold[i];
        final int start = i;
        while (i + 1 < line.length() && isBold[i + 1].equals(labelKey)) {
          i++;
        }
        // assert to make sure it matches the key to override
        assert i - start + 1 == labelKey.length();
        final String actualKey = line.substring(start, i + 1);
        sb.append(String.format(FORMAT, wordsToType.get(labelKey), actualKey));
      }
    }
    return sb.toString();
  }

  private void substring2(final String s, final String p, final String[] isBold) {
    final int[] next = getNext(p);
    final int sLen = s.length(), pLen = p.length();
    int nextStart = 0;
    int i = 0, j = 0;
    while (i < sLen && j < pLen) {
      if (j == -1 || compareCaseInsensitive(s.charAt(i), p.charAt(j))) {
        // when mismatch
        ++i;
        ++j;
      } else {
        // when match
        j = next[j];
      }

      if (j == pLen) {
        final int start = Math.max(nextStart, i - j);
        final boolean shouldReplace = Arrays.stream(isBold, start, i).
            map(curLength -> curLength.length() < p.length()).
            reduce((x, y) -> (x & y)).orElse(true);
        if (shouldReplace) {
          Arrays.fill(isBold, start, i, p);
        }
        nextStart = i;
        i--;
        j = next[j - 1]; // check the next table, infer from there
      }
    }
  }

  /**
   * Return true when 2 characters are equal when case insensitive
   *
   * @param chr1
   * @param chr2
   * @return
   */
  private static boolean compareCaseInsensitive(final char chr1, final char chr2) {
    return Character.toLowerCase(chr1) == Character.toLowerCase(chr2);
  }

  static int[] getNext(final String pattern) {
    final int[] next = new int[pattern.length()];
    if (pattern.isEmpty()) {
      return next;
    }
    Arrays.fill(next, -1);
    int k = -1, j = 0;
    while (j < pattern.length() - 1) {
      if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
        ++k;
        ++j;
        next[j] = k;
      } else {
        k = next[k];
      }
    }
    return next;
  }

}
