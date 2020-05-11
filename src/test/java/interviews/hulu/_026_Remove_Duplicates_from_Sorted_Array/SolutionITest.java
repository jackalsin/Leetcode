package interviews.hulu._026_Remove_Duplicates_from_Sorted_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 12/12/2019
 */
class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithHeadingDup(Solution solution) throws Exception {
    assertTrue(isValid(new int[]{1, 1, 2, 3, 4, 5}, solution));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase1(Solution solution) throws Exception {
    final int[] actual = {1, 1, 2}, expected = {1, 2, 2};
    final int len = solution.removeDuplicates(actual);
    assertEquals(2, len);
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase2(Solution solution) throws Exception {
    final int[] actual = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4},
        expected = {0, 1, 2, 3, 4, 2, 2, 3, 3, 4};
    final int len = solution.removeDuplicates(actual);
    assertEquals(5, len);
    assertArrayEquals(expected, actual);
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
        new SolutionI()
    );
  }
}