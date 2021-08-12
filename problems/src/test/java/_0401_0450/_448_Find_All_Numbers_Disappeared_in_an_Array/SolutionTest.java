package _0401_0450._448_Find_All_Numbers_Disappeared_in_an_Array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
    final List<Integer> actual = solution.findDisappearedNumbers(nums);
    final Set<Integer> expected = Set.of(5, 6);
    assertEquals(expected, new HashSet<>(actual));
  }

}