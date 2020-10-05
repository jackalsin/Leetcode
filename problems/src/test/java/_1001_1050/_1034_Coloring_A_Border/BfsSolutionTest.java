package _1001_1050._1034_Coloring_A_Border;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import definition.TwoDimensionArray;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BfsSolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new BfsSolution();
  }

  @Test
  void testOnlineCase1() {
    final int[][] input = {
        {1, 1}, {1, 2}
    }, expected = {
        {3, 3}, {3, 2}
    }, actual = solution.colorBorder(input, 0, 0, 3);
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, actual));
  }

  @Test
  void testOnlineCase2() {
    final int[][] input = {
        {1, 1, 1},
        {1, 1, 1},
        {1, 1, 1}
    }, expected = {
        {2, 2, 2},
        {2, 1, 2},
        {2, 2, 2}
    }, actual = solution.colorBorder(input, 1, 1, 2);
    TwoDimensionArray.println(actual);
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, actual));
  }

  @Test
  void testOnlineCase3() {
    final int[][] input = {
        {1, 2, 2}, {2, 3, 2}
    }, expected = {
        {1, 3, 3}, {2, 3, 3}
    }, actual = solution.colorBorder(input, 0, 1, 3);
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, actual));
  }
}