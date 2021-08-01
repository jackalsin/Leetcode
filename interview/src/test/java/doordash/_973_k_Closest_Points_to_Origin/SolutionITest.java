package doordash._973_k_Closest_Points_to_Origin;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {{1, 3}, {-2, 2}}, expected = {{-2, 2}};
    final int K = 1;
    final int[][] actual = solution.kClosest(input, K);
    assertArrayEquals(expected, actual, Arrays.deepToString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] input = {{3, 3}, {5, -1}, {-2, 4}}, expected = {{3, 3}, {-2, 4}};
    final int K = 2;
    final int[][] actual = solution.kClosest(input, K);
    assertArrayEquals(expected, actual, Arrays.deepToString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int K = 5;
    final int[][] input = {{10, -7}, {-3, 5}, {-6, 5}, {-5, 10}, {4, 6}, {6, 0}},
        expected = {{-3, 5}, {6, 0}, {4, 6}, {-6, 5}, {-5, 10}}, actual = solution.kClosest(input, K);
    final var unorderedActual = getSorted(actual);
    assertEquals(getSorted(expected), unorderedActual, unorderedActual.toString());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final int K = 7;
    final int[][] input = {
        {-2, 5}, {7, -2}, {-8, 0}, {2, 9}, {-1, 3}, {-3, 9}, {-6, 8}, {-5, -5}},
        expected = {{-1, 3}, {-2, 5}, {-5, -5}, {7, -2}, {-8, 0}, {2, 9}, {-3, 9}},
        actual = solution.kClosest(input, K);
    assertEquals(getSorted(expected), getSorted(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int K = 27;
    final int[][] input =
        {{-173, 567}, {-910, -93}, {-151, -260}, {555, -566}, {-577, -715}, {905, -543}, {344, -196}, {290, 510},
            {694, -611}, {878, -615}, {985, 518}, {172, -745}, {-322, 909}, {-214, 535}, {331, -447}, {-583, 473},
            {-479, 523}, {-979, -908}, {824, 809}, {119, -336}, {-892, -788}, {-820, -153}, {-854, -243}, {654, -346}
            , {352, 33}, {307, 862}, {922, 21}, {-185, 863}, {-930, 236}, {-102, 837}, {-530, 861}, {865, -881},
            {-176, -506}, {884, 954}, {653, -770}, {-938, -390}, {-15, 887}, {507, -231}, {-712, 273}, {242, 530},
            {-798, 519}, {-330, 323}, {35, 781}, {-547, -252}, {177, -229}, {465, 784}, {-51, -232}, {-221, 139},
            {-245, -112}, {690, 624}},
        actual = solution.kClosest(input, K),
        expected = {
            {-51, -232},
            {-221, 139},
            {-245, -112},
            {177, -229},
            {-151, -260},
            {352, 33},
            {119, -336},
            {344, -196},
            {-330, 323},
            {-176, -506},
            {331, -447},
            {507, -231},
            {-214, 535},
            {242, 530},
            {290, 510},
            {-173, 567},
            {-547, -252},
            {-479, 523},
            {654, -346},
            {-583, 473},
            {-712, 273},
            {172, -745},
            {35, 781},
            {555, -566},
            {-820, -153},
            {-102, 837},
            {-185, 863}};
    final List<List<Integer>> sortedActual = getSorted(actual),
        sortedExpected = getSorted(expected);
    assertEquals(sortedExpected, sortedActual);
  }

  private static List<List<Integer>> getSorted(final int[][] input) {
    final List<List<Integer>> result = new ArrayList<>();
    for (final int[] e : input) {
      result.add(List.of(e[0], e[1]));
    }
    result.sort(Comparator.comparingInt((List<Integer> a) -> a.get(0)).thenComparingInt(a -> a.get(1)));
    return result;
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new PqSolution(),
        new PqSolutionI(),
        new QuickSelectSolution(),
        new QuickSelectionSolutionI()
    );
  }
}
