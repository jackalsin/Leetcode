package google.randomPop;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 1/12/2018.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOneElement() throws Exception {
    final int[] nums = {1}, actual = solution.randomPop(new RandomPopArray(nums));
    System.out.println(Arrays.toString(actual));
    assertArrayEquals(nums, actual);
  }

  @Test
  public void testTwoElement() throws Exception {
    final int[] nums = {1, 2}, actual = solution.randomPop(new RandomPopArray(nums));
    System.out.println(Arrays.toString(actual));
    assertArrayEquals(nums, actual);
  }

  @Test
  public void testDuplicate() throws Exception {
    final int[] nums = {1, 2, 2, 2, 3, 3, 4, 4}, actual = solution.randomPop(new RandomPopArray
        (nums));
    System.out.println(Arrays.toString(actual));
    assertArrayEquals(nums, actual);
  }

  @Test
  public void testDuplicateAll() throws Exception {
    final int[] nums = {1, 1, 1, 1, 1, 1, 1, 1}, actual = solution.randomPop(new RandomPopArray
        (nums));
    System.out.println(Arrays.toString(actual));
    assertArrayEquals(nums, actual);
  }

}

