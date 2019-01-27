package _0951_1000._982_Triples_with_Bitwise_AND_Equal_To_Zero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/26/2019.
 */
class DpSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new DpSolution();
  }

  @Test
  void testOnlineCase1() {
    assertEquals(12, solution.countTriplets(new int[]{2, 1, 3}));
  }

}