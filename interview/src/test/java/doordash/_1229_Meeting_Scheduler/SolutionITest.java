package doordash._1229_Meeting_Scheduler;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/6/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] slots1 = new int[][]{{10, 50}, {60, 120}, {140, 210}}, slots2 = {{0, 15}, {60, 70}};
    final int duration = 8;
    final List<Integer> expected = List.of(60, 68), actual = solution.minAvailableDuration(slots1, slots2, duration);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] slots1 = {{10, 50}, {60, 120}, {140, 210}}, slots2 = {{0, 15}, {60, 70}};
    final int duration = 12;
    final List<Integer> expected = Collections.emptyList(), actual = solution.minAvailableDuration(slots1, slots2,
        duration);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[][] slots1 = {{216397070, 363167701}, {98730764, 158208909}, {441003187, 466254040}, {558239978,
        678368334}, {683942980, 717766451}}, slots2 = {{50490609, 222653186}, {512711631, 670791418}, {730229023,
        802410205}, {812553104, 891266775}, {230032010, 399152578}};
    final int duration = 456085;
    final List<Integer> expected = List.of(98730764, 99186849), actual = solution.minAvailableDuration(slots1, slots2,
        duration);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}