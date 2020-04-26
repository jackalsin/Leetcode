package _1401_1450._1422_Maximum_Score_After_Splitting_a_String;

/**
 * @author jacka
 * @version 1.0 on 4/11/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxScore(String s) {
    int zero = 0, one = 0;
    for (int i = 0; i < s.length(); ++i) {
      final char chr = s.charAt(i);
      if (chr == '0') {
        zero++;
      } else {
        one++;
      }
    }

    int max = 0;
    zero = 0;
    for (int i = 0; i < s.length() - 1; ++i) {
      final char chr = s.charAt(i);
      if (chr == '0') {
        zero++;
      } else {
        one--;
      }
      max = Math.max(max, one + zero);
    }
    return max;
  }
}
