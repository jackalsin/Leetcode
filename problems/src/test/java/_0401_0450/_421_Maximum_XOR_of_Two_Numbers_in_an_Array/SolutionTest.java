package _0401_0450._421_Maximum_XOR_of_Two_Numbers_in_an_Array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {3, 10, 5, 25, 2, 8};
    assertEquals(28, solution.findMaximumXOR(nums));
  }

}