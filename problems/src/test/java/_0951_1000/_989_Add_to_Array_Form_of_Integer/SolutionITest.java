package _0951_1000._989_Add_to_Array_Form_of_Integer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/5/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int A[] = {1, 2, 0, 0}, K = 34;
    List<Integer> expected = List.of(1, 2, 3, 4),
        actual = solution.addToArrayForm(A, K);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int A[] = {0}, K = 23;
    List<Integer> expected = List.of(2, 3),
        actual = solution.addToArrayForm(A, K);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}