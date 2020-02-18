package interviews.tableau._710_Random_Pick_with_Blacklist;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/17/2020
 */
@Disabled
class SolutionITest {
  private static final int MAX_COUNT = 10_000_000;
  private static final double BIAS = 1E-3;

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Class<Solution> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final int N = 4;
    final int[] blacklists = {};
    final Solution solution = solutionClass.getConstructor(Integer.TYPE, int[].class).newInstance(N, blacklists);
    final int[] counts = new int[N];
    for (int i = 0; i < MAX_COUNT; ++i) {
      counts[solution.pick()]++;
    }
    for (int i = 0; i < N; ++i) {
      assertEquals(0.25, counts[i] / (double) MAX_COUNT, BIAS);
    }
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Class<Solution> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final int N = 3;
    final int[] blacklists = {1};
    final Solution solution = solutionClass.getConstructor(Integer.TYPE, int[].class).newInstance(N, blacklists);
    final int[] counts = new int[N];
    for (int i = 0; i < MAX_COUNT; ++i) {
      counts[solution.pick()]++;
    }
    assertEquals(0.5d, counts[0] / (double) MAX_COUNT, BIAS);
    assertEquals(0.5d, counts[2] / (double) MAX_COUNT, BIAS);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Class<Solution> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final int N = 4;
    final int[] blacklists = {2};
    final Solution solution = solutionClass.getConstructor(Integer.TYPE, int[].class).newInstance(N, blacklists);
    final int[] counts = new int[N];
    for (int i = 0; i < MAX_COUNT; ++i) {
      counts[solution.pick()]++;
    }

    assertEquals(1 / 3d, counts[0] / (double) MAX_COUNT, BIAS);
    assertEquals(1 / 3d, counts[1] / (double) MAX_COUNT, BIAS);
    assertEquals(1 / 3d, counts[3] / (double) MAX_COUNT, BIAS);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Class<Solution> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final int N = 3;
    final int[] blacklists = {0};
    final Solution solution = solutionClass.getConstructor(Integer.TYPE, int[].class).newInstance(N, blacklists);
    final int[] counts = new int[N];
    for (int i = 0; i < MAX_COUNT; ++i) {
      counts[solution.pick()]++;
    }

    assertEquals(1 / 2d, counts[1] / (double) MAX_COUNT, BIAS);
    assertEquals(1 / 2d, counts[2] / (double) MAX_COUNT, BIAS);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase5(Class<Solution> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final int N = 4;
    final int[] blacklists = {0, 1};
    final Solution solution = solutionClass.getConstructor(Integer.TYPE, int[].class).newInstance(N, blacklists);
    final int[] counts = new int[N];
    for (int i = 0; i < MAX_COUNT; ++i) {
      counts[solution.pick()]++;
    }
    assertEquals(1 / 2d, counts[2] / (double) MAX_COUNT, BIAS);
    assertEquals(1 / 2d, counts[3] / (double) MAX_COUNT, BIAS);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase6(Class<Solution> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final int N = 2;
    final int[] blacklists = {1};
    final Solution solution = solutionClass.getConstructor(Integer.TYPE, int[].class).newInstance(N, blacklists);

    final int[] counts = new int[N];
    for (int i = 0; i < MAX_COUNT; ++i) {
      counts[solution.pick()]++;
    }
    assertEquals(1, counts[0] / (double) MAX_COUNT, BIAS);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase7(Class<Solution> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final int N = 4;
    final int[] blacklists = {2, 1};
    final Solution solution = solutionClass.getConstructor(Integer.TYPE, int[].class).newInstance(N, blacklists);

    final int[] counts = new int[N];
    for (int i = 0; i < MAX_COUNT; ++i) {
      counts[solution.pick()]++;
    }
    assertEquals(1d / 2, counts[0] / (double) MAX_COUNT, BIAS);
    assertEquals(1d / 2, counts[3] / (double) MAX_COUNT, BIAS);
  }

  static Stream<Class> solutionProvider() {
    return Stream.of(
        SolutionI.class
    );
  }
}