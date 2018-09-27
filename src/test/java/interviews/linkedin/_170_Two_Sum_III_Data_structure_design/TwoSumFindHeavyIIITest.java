package interviews.linkedin._170_Two_Sum_III_Data_structure_design;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public class TwoSumFindHeavyIIITest {

  private TwoSum twoSum;

  @BeforeEach
  public void setUp() throws Exception {
    twoSum = new TwoSumFindHeavyIII();
  }

  @Test
  public void test1Element() {
    twoSum.add(0);
    assertFalse(twoSum.find(0));
  }

  @Test
  public void testDuplicatedElements() {
    twoSum.add(0);
    twoSum.add(0);
    assertTrue(twoSum.find(0));
  }

  @Test
  public void testTwoDistinctElements() {
    twoSum.add(0);
    twoSum.add(1);
    assertTrue(twoSum.find(1));
  }

  @Test
  public void testFailedCase() throws Exception {
    twoSum.add(0);
    twoSum.add(-1);
    twoSum.add(1);
    assertTrue(twoSum.find(0));
  }

}
