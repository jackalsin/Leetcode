package _001_050._027_Remove_Element;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/24/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testRemoveElementWithNonExistElement() throws Exception {
    final int[] input = new int[] {2};
    final int len = solution.removeElement(input, 3);
    assertArrayEquals(new int[]{2}, input);
    assertEquals(1, len);
  }

  @Test
  public void removeElementWithNonExistElement() throws Exception {
    final int[] array = new int[] {1, 2, 3, 4, 5, 6, 7};
    int[] input = new int[array.length];
    System.arraycopy(array,0, input, 0, array.length);
    final int len = solution.removeElement(array, 8);
    assertArrayEquals(input, array);
  }

  @Test
  public void removeElementWIthSingleton() throws Exception {
    final int[] array = new int[] { 1 };
    final int len = solution.removeElement(array, 1);
    assertEquals(0, len);
    assertArrayEquals(new int[] {1}, array);

  }

}