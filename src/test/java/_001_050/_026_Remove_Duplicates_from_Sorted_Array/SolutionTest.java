package _001_050._026_Remove_Duplicates_from_Sorted_Array;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2017/1/24.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithHeadingDup() throws Exception {
    assertTrue(isValid(new int[]{1, 1, 2, 3, 4, 5}));
  }

  private boolean isValid(int[] input) {
    if (input == null)
      throw new NullPointerException();
    else {
      int len = solution.removeDuplicates(input);
      Set<Integer> finalSet = new HashSet<>();
      for (int i : input) {
        finalSet.add(i);
      }
      assertEquals(finalSet.size(), len);
      List<Integer> finalList = new ArrayList<>(finalSet);
      Collections.sort(finalList);
      for (int i = 0; i < len; i++) {
        if (!finalList.get(i).equals(input[i])) {
          return false;
        }
      }
      return true;
    }
  }

}