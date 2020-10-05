package _0701_0750._703_Kth_Largest_Element_in_a_Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/15/2020
 */
class KthLargestITest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Class<KthLargest> cacheClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final int[] nums = {4, 5, 8, 2};
    KthLargest solution = cacheClass.getConstructor(Integer.TYPE, int[].class).newInstance(3, nums);
    assertEquals(4, solution.add(3));
    assertEquals(5, solution.add(5));
    assertEquals(5, solution.add(10));
    assertEquals(8, solution.add(9));
    assertEquals(8, solution.add(4));
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        KthLargestI.class
    );
  }
}