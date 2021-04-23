package facebook._1570_Dot_Product_of_Two_Sparse_Vectors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/22/2021
 */
class SparseVectorTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Class<SparseVector> solutionClass) throws NoSuchMethodException, InvocationTargetException,
      InstantiationException, IllegalAccessException {
    final int[] nums1 = {1, 0, 0, 2, 3}, nums2 = {0, 3, 0, 4, 0};
    SparseVector sparseVector1 = solutionClass.getConstructor(int[].class).newInstance(nums1),
        sparseVector2 = solutionClass.getConstructor(int[].class).newInstance(nums2);
    assertEquals(8, sparseVector2.dotProduct(sparseVector1));
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        SparseVector.class
    );
  }
}