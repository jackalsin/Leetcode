package _1051_1100._1078_Occurrences_After_Bigram;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhixi
 * @version 1.0 on 11/29/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String[] findOcurrences(String text, String first, String second) {
    final String[] texts = text.split(" ");
    final List<String> result = new ArrayList<>();
    final int len = texts.length;
    for (int i = 0; i + 2 < len; ++i) {
      if (texts[i].equals(first) && texts[i + 1].equals(second)) {
        result.add(texts[i + 2]);
      }
    }
    return result.toArray(new String[0]);
  }
}
