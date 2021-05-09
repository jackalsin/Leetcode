package google._1055_Shortest_Way_to_Form_String;

/**
 * @author jacka
 * @version 1.0 on 5/8/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int shortestWay(String source, String target) {
    final char[] srcs = source.toCharArray(), tgts = target.toCharArray();
    int steps = 1;
    for (int j = 0; j < target.length(); ) {
      boolean foundOnce = false;
      for (int i = 0; i < source.length(); ++i) {
        if (srcs[i] == tgts[j]) {
          ++j;
          foundOnce = true;
          if (j == target.length()) return steps;
        }
      }
      if (!foundOnce) {
        return -1;
      }
      steps++;
    }
    return -1;
  }
}
