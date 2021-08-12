package _0401_0450._447_Number_of_Boomerangs;

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
    final int[][] points = {{0, 0}, {1, 0}, {2, 0}};
    assertEquals(2, solution.numberOfBoomerangs(points));
  }

}