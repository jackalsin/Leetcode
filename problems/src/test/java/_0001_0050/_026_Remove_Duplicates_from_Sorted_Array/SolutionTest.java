package _0001_0050._026_Remove_Duplicates_from_Sorted_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2017/1/24.
 */
public class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithHeadingDup(Solution solution) throws Exception {
    assertTrue(isValid(new int[]{1, 1, 2, 3, 4, 5}, solution));
  }

  private boolean isValid(int[] input, final Solution solution) {
    if (input == null)
      throw new NullPointerException();
    else {
      int len = solution.removeDuplicates(input);
      Set<Integer> finalSet = new HashSet<>();
      for (int i : input) {
        finalSet.add(i);
      }
      assertEquals(finalSet.size(), len);
      List<Integer> finalList = new ArrayList<>(finalSet);
      Collections.sort(finalList);
      for (int i = 0; i < len; i++) {
        if (!finalList.get(i).equals(input[i])) {
          return false;
        }
      }
      return true;
    }
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

}