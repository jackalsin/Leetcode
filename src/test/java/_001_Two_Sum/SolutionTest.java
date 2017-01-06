package _001_Two_Sum;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/6.
 */
public class SolutionTest {
  private static final int[] TWO_ELEMS = new int[] {1, 2};
  private static final int[] WEB_REF = new int[] {2, 7, 11, 15};
  private static final int[] THREE_ELEM = new int[] {3, 2, 4};

  @Test
  public void twoSumWithTwoElems() throws Exception {
    assertArrayEquals(new int[] {0, 1}, new Solution().twoSum(TWO_ELEMS, 3));
  }

  @Test
  public void twoSumWithWebRef() throws Exception {
    assertArrayEquals(new int[] {0, 1}, new Solution().twoSum(WEB_REF, 9));
  }

  @Test
  public void twoSumWithThreeElems() throws Exception {
    assertArrayEquals(new int[] {1, 2}, new Solution().twoSum(THREE_ELEM, 6));
  }
}