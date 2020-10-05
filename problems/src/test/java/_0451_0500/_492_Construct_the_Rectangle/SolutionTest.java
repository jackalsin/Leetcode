package _0451_0500._492_Construct_the_Rectangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    assertArrayEquals(new int[]{2, 2}, solution.constructRectangle(4));
  }

  @Test
  void testOnlineCase2() {
    final int[] actual = solution.constructRectangle(10000000);
    System.out.println(Arrays.toString(actual));
    assertArrayEquals(new int[]{3200, 3125}, actual);
  }
}