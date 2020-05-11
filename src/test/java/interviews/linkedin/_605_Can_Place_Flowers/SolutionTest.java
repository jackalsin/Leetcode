package interviews.linkedin._605_Can_Place_Flowers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final int[] followerBed = {1, 0, 0, 0, 1};
    assertTrue(solution.canPlaceFlowers(followerBed, 1));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] followerBed = {1, 0, 0, 0, 1};
    assertFalse(solution.canPlaceFlowers(followerBed, 2));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(Solution solution) {
    final int[] followerBed = {1, 0, 0, 0, 0, 1};
    assertFalse(solution.canPlaceFlowers(followerBed, 2));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Solution solution) {
    final int[] followerBed = {};
    assertFalse(solution.canPlaceFlowers(followerBed, 1));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testSinglePlot(Solution solution) {
    final int[] followerBed = {0};
    assertTrue(solution.canPlaceFlowers(followerBed, 1));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase2(Solution solution) {
    final int[] flowerBed = {0, 0, 0, 0, 0, 1, 0, 0};
    assertTrue(solution.canPlaceFlowers(flowerBed, 0));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV(),
        new SolutionV()
    );
  }
}