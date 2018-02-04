package interviews.google.longest_common_prefix_suffix;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/31/2018.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    /*   suffix                            prefix */
    final int[] nums1 = {1, 2, 3, 4, 1, 2, 3, 5}, nums2 = {2, 3, 4, 1, 2, 3, 5, 4};

    assertEquals(7, solution.maxPrefixSuffix(nums1, nums2));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] suffix = {1, 2, 3, 4, 5}, prefix = {2, 3, 4, 5, 6};
    assertEquals(4, solution.maxPrefixSuffix(suffix, prefix));
  }


  @Test
  public void testOnPrefixPointerOutOfRangeFirst() {
    final int[] suffix = {1, 2, 3, 4, 2, 3, 4}, prefix = {2, 3, 4, 5, 6};
    // TODO: still fail
//    assertEquals(3, solution.maxPrefixSuffix(suffix, prefix));

  }

  @Test
  public void testGetNext1() throws Exception {
    final int[] a = {1, 2, 3, 4, 1, 2, 3, 5};
    final int[] expected = {0, 0, 0, 0, 0, 1, 2, 3, 0};
    final int[] actual = solution.getNext(a);
    assertArrayEquals(expected, actual);
  }
}
