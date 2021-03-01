package apple._398_Random_Pick_Index;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/28/2021
 */
class SolutionITest {
  private static final double BIAS = 1E-3;

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Class<Solution> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final int[] nums = {1, 2, 3, 3, 3};
    Solution solution = solutionClass.getConstructor(int[].class).newInstance(nums);
    assertEquals(0, solution.pick(1));
    assertEquals(1, solution.pick(2));
    assertTrue(Set.of(2, 3, 4).contains(solution.pick(3)));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Class<Solution> cacheClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final int[] nums = {1, 2, 3, 3, 3};
    Solution solution = cacheClass.getConstructor(int[].class).newInstance(nums);
    assertEquals(0, solution.pick(1));
    assertEquals(1, solution.pick(2));
    final int[] counts = new int[5];
    final int COUNT = 3_000_000;
    final double[] chances = new double[5];
    for (int i = 0; i < COUNT; i++) {
      int res = solution.pick(3);
      counts[res]++;
    }
    for (int i = 0; i < chances.length; i++) {
      chances[i] = (double) counts[i] / COUNT;
    }
    for (int i = 2; i < chances.length; ++i) {
      assertEquals(1d / 3, chances[i], BIAS, Arrays.toString(chances));
    }
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        ReverseMapSolution.class,
        ReservoirSampleSolution.class
    );
  }
}