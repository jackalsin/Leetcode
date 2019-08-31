package interviews.linkedin._170_Two_Sum_III_Data_structure_design;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
class TwoSumTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test1Element(TwoSum twoSum) {
    twoSum.add(0);
    assertFalse(twoSum.find(0));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testDuplicatedElements(TwoSum twoSum) {
    twoSum.add(0);
    twoSum.add(0);
    assertTrue(twoSum.find(0));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testTwoDistinctElements(TwoSum twoSum) {
    twoSum.add(0);
    twoSum.add(1);
    assertTrue(twoSum.find(1));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase(TwoSum twoSum) {
    twoSum.add(0);
    twoSum.add(-1);
    twoSum.add(1);
    assertTrue(twoSum.find(0));
  }

  static Stream<TwoSum> solutionProvider() {
    return Stream.of(
        new TwoSumAddHeavy(),
        new TwoSumAddHeavyII(),
        new TwoSumAddHeavyIII(),
        new TwoSumAddHeavyIV(),
        new TwoSumFindHeavyII(),
        new TwoSumFindHeavyIII()
    );
  }
}
