package _1251_1300._1298_Maximum_Candies_You_Can_Get_from_Boxes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 8/14/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int status[] = {1, 0, 1, 0}, candies[] = {7, 5, 4, 100},
        keys[][] = {{}, {}, {1}, {}}, containedBoxes[][] = {{1, 2}, {3}
        , {}, {}}, initialBoxes[] = {0}, expected = 16,
        actual = solution.maxCandies(status, candies, keys, containedBoxes, initialBoxes);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int status[] = {1, 0, 0, 0, 0, 0}, candies[] = {1, 1, 1, 1, 1, 1},
        keys[][] = {{1, 2, 3, 4, 5}, {}, {}, {}, {}, {}}, containedBoxes[][] = {{1, 2, 3, 4, 5},
        {}, {}, {}, {}, {}}, initialBoxes[] =
        {0}, expected = 6,
        actual = solution.maxCandies(status, candies, keys, containedBoxes, initialBoxes);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int status[] = {1, 1, 1}, candies[] = {100, 1, 100},
        keys[][] = {{}, {0, 2}, {}, {}}, containedBoxes[][] = {{}, {}, {}}, initialBoxes[] =
        {1}, expected = 1,
        actual = solution.maxCandies(status, candies, keys, containedBoxes, initialBoxes);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final int status[] = {1}, candies[] = {100},
        keys[][] = {{}}, containedBoxes[][] = {{}}, initialBoxes[] =
        {}, expected = 0,
        actual = solution.maxCandies(status, candies, keys, containedBoxes, initialBoxes);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase5(Solution solution) {
    final int status[] = {1, 1, 1}, candies[] = {2, 3, 2},
        keys[][] = {{}, {}, {}}, containedBoxes[][] = {{}, {}, {}}, initialBoxes[] =
        {2, 1, 0}, expected = 7,
        actual = solution.maxCandies(status, candies, keys, containedBoxes, initialBoxes);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}