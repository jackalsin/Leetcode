package _1551_1600._1595_Minimum_Cost_to_Connect_Two_Groups_of_Points;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/20/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final List<List<Integer>> input = List.of(
        List.of(15, 96),
        List.of(36, 2)
    );
    final int actual = solution.connectTwoGroups(input),
        expected = 17;
    assertEquals(expected, actual);
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final List<List<Integer>> input = List.of(
        List.of(1, 1),
        List.of(2, 2)
    );
    final int actual = solution.connectTwoGroups(input),
        expected = 3;
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final List<List<Integer>> input = List.of(
        List.of(1, 3, 5),
        List.of(4, 1, 1),
        List.of(1, 5, 3)
    );
    final int actual = solution.connectTwoGroups(input),
        expected = 4;
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionI()
    );
  }
}