package _0801_0850._842_Split_Array_into_Fibonacci_Sequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 9/3/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String s = "123456579";
    final List<Integer> expected = List.of(123, 456, 579),
        actual = solution.splitIntoFibonacci(s);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String s = "11235813";
    final List<Integer> expected = List.of(1, 1, 2, 3, 5, 8, 13),
        actual = solution.splitIntoFibonacci(s);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String s = "112358130";
    final List<Integer> expected = List.of(),
        actual = solution.splitIntoFibonacci(s);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final String s = "0123";
    final List<Integer> expected = List.of(),
        actual = solution.splitIntoFibonacci(s);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final String s = "1101111";
    final List<Integer> actual = solution.splitIntoFibonacci(s);
    final Set<List<Integer>> expected = Set.of(
        List.of(110, 1, 111),
        List.of(11, 0, 11, 11)
    );
    assertTrue(expected.contains(actual), "Found = " + actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase6(Solution solution) {
    final String s = "1011";
    final List<Integer> actual = solution.splitIntoFibonacci(s);
    final Set<List<Integer>> expected = Set.of(
        List.of(1, 0, 1, 1)
    );
    assertTrue(expected.contains(actual), "Found = " + actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}