package _201_250._229_Majority_Element_II;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 8/17/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testCase() throws Exception {
    final int[] input = new int[] {3, 3, 4, 3, 2, 3, 2, 2, 3, 3, 2}; // 3->6, 2 ->4, 4->1
    final Set<Integer> expected= new HashSet<>(Arrays.asList(3, 2));
    final List<Integer> actual = solution.majorityElement(input);
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));
  }
}
