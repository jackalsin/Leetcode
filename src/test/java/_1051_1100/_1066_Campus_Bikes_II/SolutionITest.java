package _1051_1100._1066_Campus_Bikes_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/21/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[][] workers = {{0, 0}, {2, 1}}, bikes = {{1, 2}, {3, 3}};
    assertEquals(6, solution.assignBikes(workers, bikes));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[][] workers = {{0, 0}, {1, 1}, {2, 0}}, bikes = {{1, 0}, {2, 2}, {2, 1}};
    assertEquals(4, solution.assignBikes(workers, bikes));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[][] workers = {{0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 0}},
        bikes = {{0, 999}, {1, 999}, {2, 999}, {3, 999}, {4, 999}, {5, 999}};
    assertEquals(999 * 5, solution.assignBikes(workers, bikes));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    //                        0           1             2         3         4           5
    final int[][] workers = {{586, 230}, {563, 941}, {714, 182}, {32, 97}, {448, 259}, {103, 716}},
        //        6          7            8           9           10          11          12
        bikes = {{28, 114}, {395, 191}, {765, 383}, {275, 669}, {595, 174}, {530, 262}, {483, 547}};
    // match
    // [0, 11] 88
    // [1, 12] 474
    // [2, 10] 127
    // [3, 6] 21
    // [4, 7] 121
    // [5, 9] 219
    assertEquals(1050, solution.assignBikes(workers, bikes));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new BruteForceSolution(),
        new FordFulkersonSolution()
    );
  }
}