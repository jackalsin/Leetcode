package _1051_1100._1055_Shortest_Way_to_Form_String;

/**
 * @author jacka
 * @version 1.0 on 3/15/2020
 */
public final class GreedySolutionI implements Solution {
  @Override
  public int shortestWay(String source, String target) {
    final char[] targetChars = target.toCharArray(),
        sourceChars = source.toCharArray();
    int step = 1;
    targetLoop:
    for (int i = 0; i < target.length(); ) {
      boolean foundOnce = false;
      for (char sourceChar : sourceChars) {
        if (targetChars[i] == sourceChar) {
          i++;
          foundOnce = true;
          if (i == target.length()) {
            break targetLoop;
          }
        }
      }
      if (!foundOnce) {
        return -1;
      }
      step++;
    }
    return step;
  }
}
