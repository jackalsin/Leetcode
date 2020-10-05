package _0951_1000._982_Triples_with_Bitwise_AND_Equal_To_Zero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MySolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new MySolution();
  }

  @Test
  void testOnlineCase1() {
    assertEquals(12, solution.countTriplets(new int[]{2, 1, 3}));
  }
}