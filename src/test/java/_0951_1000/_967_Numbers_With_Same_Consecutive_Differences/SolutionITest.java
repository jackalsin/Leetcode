package _0951_1000._967_Numbers_With_Same_Consecutive_Differences;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 10/3/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int n = 3, k = 7;
    final Set<Integer> expected = Set.of(181, 292, 707, 818, 929);
    final int[] actual = solution.numsSameConsecDiff(n, k);
    assertEquals(expected, Arrays.stream(actual).boxed().collect(Collectors.toSet()));
    assertEquals(expected.size(), actual.length);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int n = 2, k = 1;
    final Set<Integer> expected = Set.of(10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98);
    final int[] actual = solution.numsSameConsecDiff(n, k);
    assertEquals(expected, Arrays.stream(actual).boxed().collect(Collectors.toSet()));
    assertEquals(expected.size(), actual.length);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int n = 2, k = 0;
    final Set<Integer> expected = Set.of(11, 22, 33, 44, 55, 66, 77, 88, 99);
    final int[] actual = solution.numsSameConsecDiff(n, k);
    assertEquals(expected, Arrays.stream(actual).boxed().collect(Collectors.toSet()));
    assertEquals(expected.size(), actual.length);

  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final int n = 2, k = 1;
    final Set<Integer> expected = Set.of(10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98);
    final int[] actual = solution.numsSameConsecDiff(n, k);
    assertEquals(expected, Arrays.stream(actual).boxed().collect(Collectors.toSet()));
    assertEquals(expected.size(), actual.length);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase5(Solution solution) {
    final int n = 2, k = 2;
    final Set<Integer> expected = Set.of(13, 20, 24, 31, 35, 42, 46, 53, 57, 64, 68, 75, 79, 86, 97);
    final int[] actual = solution.numsSameConsecDiff(n, k);
    assertEquals(expected, Arrays.stream(actual).boxed().collect(Collectors.toSet()));
    assertEquals(expected.size(), actual.length);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}