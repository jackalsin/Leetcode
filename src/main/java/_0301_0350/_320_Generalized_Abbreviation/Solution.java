package _0301_0350._320_Generalized_Abbreviation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Write a function to generate the generalized abbreviations of a word.
 * Example:
 * Given word = "word", return the following list (order does not matter):
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2",
 * "2r1", "3d", "w3", "4"]
 *
 * @author jacka
 * @version 1.0 on 9/23/2017.
 */
public class Solution {
  public List<String> generateAbbreviations(String word) {
    final List<String> result = new ArrayList<>();
    generateAbbreviationsHelper(result, word, new StringBuilder(), 0, 0);
    return result;
  }

  private void generateAbbreviationsHelper(List<String> result, String word,
                                           StringBuilder path, int pos, int count) {
    final int len = path.length();
    if (pos == word.length()) {
      if (count > 0) path.append(count);
      result.add(path.toString());
      if (count > 0) path.setLength(len);
    } else {
      // use as a char
      if (count > 0) path.append(count);
      path.append(word.charAt(pos));
      generateAbbreviationsHelper(result, word, path, pos + 1, 0);
      path.setLength(len);
      // use as count
      generateAbbreviationsHelper(result, word, path, pos + 1, count + 1);
    }
  }
}
