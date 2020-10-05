package _0401_0450._411_Minimum_Unique_Word_Abbreviation;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BruteForceSolution implements Solution {
  /**
   * 46 / 46 test cases passed.
   * Status: Accepted
   * Runtime: 216 ms
   *
   * @param target
   * @param dictionary
   * @return
   */
  @Override
  public String minAbbreviation(String target, String[] dictionary) {
    if (dictionary.length == 0) return String.valueOf(target.length());
    Queue<Abbreviation> pq = new PriorityQueue<>(new Comparator<Abbreviation>() {
      @Override
      public int compare(Abbreviation o1, Abbreviation o2) {
        return Integer.compare(o1.len, o2.len);
      }
    });
    generateAll(pq, target, new StringBuilder(), 0, 0);
    while (!pq.isEmpty()) {
      final String abbreviation = pq.poll().abbr;
      boolean isNotValidAbbrForAll = true;
      for (final String word : dictionary) {
        if (isValidAbbr(word, abbreviation)) {
          isNotValidAbbrForAll = false;
          break;
        }
      }
      if (isNotValidAbbrForAll) {
        return abbreviation;
      }
    }

    return target;
  }

  /**
   * This abbreviation doesn't contains a02b tricky stuff.
   *
   * @param word
   * @param abbreviation
   * @return
   */
  static boolean isValidAbbr(final String word, final String abbreviation) {
    int wordPtr = 0;
    for (int i = 0; i < abbreviation.length(); ) {
      if (Character.isDigit(abbreviation.charAt(i))) { // parse digit
        int skip = 0;
        for (; i < abbreviation.length() && Character.isDigit(abbreviation.charAt(i)); i++) {
          skip = 10 * skip + abbreviation.charAt(i) - '0';
        }
        wordPtr += skip;

      } else {
        if (wordPtr >= word.length() || word.charAt(wordPtr++) != abbreviation.charAt(i++)) {
          return false;
        }
      }
    }
    return wordPtr == word.length();
  }

  private void generateAll(final Queue<Abbreviation> pq, final String target, final StringBuilder curPath, int start,
                           int count) {
    final int len = curPath.length();
    if (start == target.length()) {
      if (count > 0) curPath.append(count);
      pq.add(new Abbreviation(curPath.toString(), curPath.length()));
      if (count > 0) curPath.setLength(len);
    } else {
      // use as a count;
      generateAll(pq, target, curPath, start + 1, count + 1);
      // use as a char;
      if (count > 0) curPath.append(count);
      curPath.append(target.charAt(start));
      generateAll(pq, target, curPath, start + 1, 0);
      curPath.setLength(len);
    }
  }

  private static class Abbreviation {
    private final String abbr;
    private final int len;

    private Abbreviation(String abbr, int len) {
      this.abbr = abbr;
      this.len = len;
    }
  }
}
