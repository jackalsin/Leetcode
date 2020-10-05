package _1401_1450._1441_Build_an_Array_With_Stack_Operations;


import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/11/2020
 */
public final class SolutionI implements Solution {
  private static final String PUSH = "Push", POP = "Pop";

  public List<String> buildArray(int[] target, int n) {
    final List<String> result = new ArrayList<>();
    for (int i = 0, val = 1; i < target.length; ++i) {
      while (val != target[i]) {
        result.add(PUSH);
        result.add(POP);
        val++;
      }
      result.add(PUSH);
      val++;
    }
    return result;
  }
}
