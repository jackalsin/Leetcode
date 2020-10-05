package _1201_1250._1203_Sort_Items_by_Groups_Respecting_Dependencies;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 9/23/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int n = 8, m = 2,
        group[] = {-1, -1, 1, 0, 0, 1, 0, -1};
    final Set<List<Integer>> expected = Set.of(
        List.of(6, 3, 4, 5, 2, 1, 0, 7),
        List.of(6, 3, 4, 5, 2, 1, 7, 0),
        List.of(6, 3, 4, 5, 2, 0, 1, 7),
        List.of(6, 3, 4, 5, 2, 0, 7, 1),
        List.of(6, 3, 4, 5, 2, 7, 0, 1),
        List.of(6, 3, 4, 5, 2, 7, 1, 0),

        List.of(6, 3, 4, 1, 5, 2, 0, 7),
        List.of(6, 3, 4, 1, 5, 2, 7, 0),
        List.of(6, 3, 4, 1, 0, 5, 2, 7),
        List.of(6, 3, 4, 1, 0, 7, 5, 2),
        List.of(6, 3, 4, 1, 7, 5, 2, 0),
        List.of(6, 3, 4, 1, 7, 0, 5, 2),

        List.of(6, 3, 4, 0, 5, 2, 1, 7),
        List.of(6, 3, 4, 0, 5, 2, 7, 1),
        List.of(6, 3, 4, 0, 1, 5, 2, 7),
        List.of(6, 3, 4, 0, 1, 7, 5, 2),
        List.of(6, 3, 4, 0, 7, 5, 2, 1),
        List.of(6, 3, 4, 0, 7, 1, 5, 2),

        List.of(6, 3, 4, 7, 5, 2, 1, 0),
        List.of(6, 3, 4, 7, 5, 2, 0, 1),
        List.of(6, 3, 4, 7, 1, 5, 2, 0),
        List.of(6, 3, 4, 7, 1, 0, 5, 2),
        List.of(6, 3, 4, 7, 0, 5, 2, 1),
        List.of(6, 3, 4, 7, 0, 1, 5, 2)
    );

    final List<List<Integer>> beforeItems = List.of(
        List.of(), // 0
        List.of(6), // 1
        List.of(5), // 2
        List.of(6), // 3
        List.of(3, 6),  // 4
        List.of(),  // 5
        List.of(),  // 6
        List.of() // 7
    );
    final int[] actual = solution.sortItems(n, m, group, beforeItems);
    final List<Integer> actualList = toList(actual);
    assertTrue(expected.contains(actualList));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(Solution solution) {
    final int n = 5, m = 5,
        group[] = {2, 0, -1, 3, 0},
        expected[] = {3, 2, 4, 1, 0};
    final List<List<Integer>> beforeItems = List.of(
        List.of(2, 1, 3), // 0
        List.of(2, 4), // 1
        List.of(),  // 2
        List.of(),  // 3
        List.of() // 4
    );
    final int[] actual = solution.sortItems(n, m, group, beforeItems);
//    System.out.println(Arrays.toString(actual));
    assertArrayEquals(expected, actual);
  }

  private static List<Integer> toList(final int[] array) {
    if (array == null) {
      return null;
    }
    final List<Integer> result = new ArrayList<>();
    for (int a : array) {
      result.add(a);
    }
    return result;
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}