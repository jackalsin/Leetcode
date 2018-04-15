package _401_450._442_Find_All_Duplicates_in_an_Array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
    final List<Integer> expected = List.of(2, 3);

    assertEquals(expected, solution.findDuplicates(nums));
  }
}