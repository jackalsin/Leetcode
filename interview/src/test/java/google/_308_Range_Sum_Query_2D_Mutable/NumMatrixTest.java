package google._308_Range_Sum_Query_2D_Mutable;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/30/2018.
 */
public class NumMatrixTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnline(Class<NumMatrix> solution) throws Exception {
    final int[][] input = {
        {3, 0, 1, 4, 2},
        {5, 6, 3, 2, 1},
        {1, 2, 0, 1, 5},
        {4, 1, 0, 1, 7},
        {1, 0, 3, 0, 5}
    };
    NumMatrix numMatrix = solution.getConstructor(int[][].class).newInstance((Object) input);
    assertEquals(8, numMatrix.sumRegion(2, 1, 4, 3));
    numMatrix.update(3, 2, 2);
    assertEquals(10, numMatrix.sumRegion(2, 1, 4, 3));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Class<NumMatrix> solution) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    NumMatrix numMatrix = solution.getConstructor(int[][].class).newInstance((Object) new int[][]{});
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Class<NumMatrix> solution) throws Exception {
    final int[][] input = {
        {1, 2}
    };
    NumMatrix numMatrix = solution.getConstructor(int[][].class).newInstance((Object) input);
    assertEquals(1, numMatrix.sumRegion(0, 0, 0, 0));
    assertEquals(2, numMatrix.sumRegion(0, 1, 0, 1));
    assertEquals(3, numMatrix.sumRegion(0, 0, 0, 1));
    numMatrix.update(0, 0, 3);
    numMatrix.update(0, 1, 5);
    assertEquals(8, numMatrix.sumRegion(0, 0, 0, 1));
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        NumMatrixI.class,
        NumMatrixII.class
    );
  }
}
