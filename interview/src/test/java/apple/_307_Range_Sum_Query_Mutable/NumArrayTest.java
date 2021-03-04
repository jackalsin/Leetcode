package apple._307_Range_Sum_Query_Mutable;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/3/2021
 */
class NumArrayTest {

  static Stream<Class> solutionStream() {
    return Stream.of(
        NumArrayI.class,
        SegmentTreeArraySolution.class
    );
  }

  /**
   * Given nums = [1, 3, 5]
   * <p>
   * sumRange(0, 2) -> 9
   * update(1, 2)
   * sumRange(0, 2) -> 8
   *
   * @throws Exception
   */
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnline(Class<NumArray> solution) throws Exception {
    final int[] nums = {1, 3, 5};
    NumArray numArray = solution.getConstructor(int[].class).newInstance(nums);
    assertEquals(9, numArray.sumRange(0, 2));
    numArray.update(1, 2);
    assertEquals(8, numArray.sumRange(0, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testEmpty(Class<NumArray> solution) throws Exception {
    final int[] nums = {};
    NumArray numArray = solution.getConstructor(int[].class).newInstance(nums);
  }

  /**
   * ["NumArray","update","update","update","sumRange","update","sumRange","update","sumRange","sumRange","update"]
   * [[[7,2,7,2,0]],[4,6],  [0,2],    [0,9],  [4,4],      [3,8],  [0,4],      [ 4,1],   [0,3],    [0,4],     [0,4]]
   * expectation [null,null,null,null,6,null,32,null,26,27,null]
   *
   * @throws Exception
   */
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailed1(Class<NumArray> solution) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final int[] input = {7, 2, 7, 2, 0};
    NumArray numArray = solution.getConstructor(int[].class).newInstance(input);
    numArray.update(4, 6);
    numArray.update(0, 2);
    numArray.update(0, 9);
    assertEquals(6, numArray.sumRange(4, 4));
    numArray.update(3, 8);
    assertEquals(32, numArray.sumRange(0, 4));
    numArray.update(4, 1);
    assertEquals(26, numArray.sumRange(0, 3));
    assertEquals(27, numArray.sumRange(0, 4));
    numArray.update(0, 4);
  }


  /**
   * ["NumArray",                             "sumRange","update","sumRange","sumRange","update","update","sumRange",
   * "sumRange","update","update"]
   * [[[-28,-39,53,65,11,-56,-65,-39,-43,97]],[5,6],[9,27],[2,3],[6,7],[1,-82],[3,-72],[3,7],[1,8],[5,13],[4,-67]]
   * expectation                        [null,-121,null,118,-104,null,null,-221,-293,null,null]
   *
   * @throws Exception
   */
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailed2(Class<NumArray> solution) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final int[] input = {-28, -39, 53, 65, 11, -56, -65, -39, -43, 97};
    NumArray numArray = solution.getConstructor(int[].class).newInstance(input);
    assertEquals(-121, numArray.sumRange(5, 6));
    numArray.update(9, 27);
    assertEquals(118, numArray.sumRange(2, 3));
    assertEquals(-104, numArray.sumRange(6, 7));
  }
}