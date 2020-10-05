package _0701_0750._735_Asteroid_Collision;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 2/3/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    final int[] asteroids = {5, 10, -5};
    final int[] actual = solution.asteroidCollision(asteroids);
    final int[] expected = {5, 10};
    assertArrayEquals(expected, actual);
  }

  @Test
  void testOnlineCase2() throws Exception {
    final int[] asteroids = {8, -8};
    final int[] actual = solution.asteroidCollision(asteroids);
    final int[] expected = {};
    assertArrayEquals(expected, actual);
  }

  @Test
  void testOnlineCase3() throws Exception {
    final int[] asteroids = {10, 2, -5};
    final int[] actual = solution.asteroidCollision(asteroids);
    final int[] expected = {10};
    assertArrayEquals(expected, actual);
  }

  @Test
  void testOnlineCase4() throws Exception {
    final int[] asteroids = {-2, -1, 1, 2};
    final int[] actual = solution.asteroidCollision(asteroids);
    final int[] expected = {-2, -1, 1, 2};
    assertArrayEquals(expected, actual);
  }

  @Test
  void testFailedCase1() throws Exception {
    final int[] asteroids = {-2, -2, -1, -2};
    final int[] actual = solution.asteroidCollision(asteroids);
    final int[] expected = {-2, -2, -1, -2};
    assertArrayEquals(expected, actual);
  }

  @Test
  void testFailedCase3() throws Exception {
    final int[] asteroids = {-2, -2, 1, -2};
    final int[] actual = solution.asteroidCollision(asteroids);
    final int[] expected = {-2, -2, -2};
    assertArrayEquals(expected, actual);
  }

  @Test
  void testFailedCase2() throws Exception {
    final int[] asteroids = {4, 5, 6, -7};
    final int[] actual = solution.asteroidCollision(asteroids);
    final int[] expected = {-7};
    assertArrayEquals(expected, actual);
  }
}
