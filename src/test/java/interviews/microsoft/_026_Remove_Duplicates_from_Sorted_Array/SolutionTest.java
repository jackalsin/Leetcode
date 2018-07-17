package interviews.microsoft._026_Remove_Duplicates_from_Sorted_Array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithHeadingDup() {
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