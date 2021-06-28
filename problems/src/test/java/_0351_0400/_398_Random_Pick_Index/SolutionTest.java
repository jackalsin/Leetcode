package _0351_0400._398_Random_Pick_Index;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author jacka
 * @version 1.0 on 1/11/2018.
 */
public class SolutionTest {

  private static final double BIAS = 1E-3;

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Class<Solution> cacheClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final int[] nums = {1, 2, 3, 3, 3};
    Solution solution = cacheClass.getConstructor(int[].class).newInstance(nums);
    Assertions.assertEquals(0, solution.pick(1));
    Assertions.assertEquals(1, solution.pick(2));
    final int[] counts = new int[5];
    final int COUNT = 10_000_000;
    final double[] chances = new double[5];
    for (int i = 0; i < COUNT; i++) {
      int res = solution.pick(3);
      counts[res]++;
    }

    for (int i = 2; i < chances.length; i++) {
      Assertions.assertEquals(1d / 3, (double) counts[i] / COUNT, BIAS);
    }
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Class<Solution> cacheClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final int[] nums = {1, 2, 3, 3, 3};
    Solution solution = cacheClass.getConstructor(int[].class).newInstance(nums);
    Assertions.assertEquals(0, solution.pick(1));
    Assertions.assertEquals(1, solution.pick(2));
    Assertions.assertTrue(Set.of(2, 3, 4).contains(solution.pick(3)));
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        NaiveSolution.class,
        ReservoirSampleSolution.class
    );
  }
}
