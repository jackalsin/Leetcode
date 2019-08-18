package interviews.linkedin._694_Number_of_Distinct_Islands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author jacka
 * @version 1.0 on 8/18/2019
 */
class SolutionITest {
  @Test
  void testDuplicateResult() {
    assertNotEquals(0b0000_0000_0000_1000_0000_0000_0000_0010, SolutionI.getVal(8, -2));
    assertNotEquals(0b0000_0000_0000_0111_0000_0000_0000_0010, SolutionI.getVal(7, 2));
  }
}