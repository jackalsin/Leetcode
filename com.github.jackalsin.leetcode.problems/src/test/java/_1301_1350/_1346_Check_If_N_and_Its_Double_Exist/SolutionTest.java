package _1301_1350._1346_Check_If_N_and_Its_Double_Exist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/8/2020
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(SolutionI solution) {
    final int[] input = {10, 2, 5, 3};
    assertTrue(solution.checkIfExist(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(SolutionI solution) {
    final int[] input = {5, 10, 2, 3};
    assertTrue(solution.checkIfExist(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(SolutionI solution) {
    final int[] input = {1};
    assertFalse(solution.checkIfExist(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(SolutionI solution) {
    final int[] input = {-20, 8, -6, -14, 0, -19, 14, 4};
    assertTrue(solution.checkIfExist(input));
  }

  static Stream<SolutionI> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}