package _1451_1500._1451_Rearrange_Words_in_a_Sentence;

import java.util.Arrays;

public final class SolutionI implements Solution {
  @Override
  public String arrangeWords(String text) {
    final String[] items = text.toLowerCase().split(" ");
    Arrays.sort(items, (a, b) -> Integer.compare(a.length(), b.length()));
    final String result = String.join(" ", items);
    return Character.toUpperCase(result.charAt(0)) + result.substring(1);
  }

}
