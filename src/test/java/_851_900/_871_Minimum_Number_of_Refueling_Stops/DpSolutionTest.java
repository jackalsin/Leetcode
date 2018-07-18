package _851_900._871_Minimum_Number_of_Refueling_Stops;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DpSolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new DpSolution();

  }

  @Test
  void testOnlineCase1() {
    final int target = 1, startFuel = 1;
    final int[][] stations = {};
    assertEquals(0, solution.minRefuelStops(target, startFuel, stations));
  }


  @Test
  void testOnlineCase2() {
    final int target = 100, startFuel = 1;
    final int[][] stations = {{10, 100}};
    assertEquals(-1, solution.minRefuelStops(target, startFuel, stations));
  }

  @Test
  void testOnlineCase3() {
    final int target = 100, startFuel = 10;
    final int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
    assertEquals(2, solution.minRefuelStops(target, startFuel, stations));
  }

  @Test
  void testOnlineCase4() {
    final int target = 1000, startFuel = 299;
    final int[][] stations = {
        {13, 21}, {26, 115}, {100, 47}, {225, 99}, {299, 141}, {444, 198}, {608, 190}, {636, 157}, {647, 255}, {841, 123}
    };
    assertEquals(4, solution.minRefuelStops(target, startFuel, stations));
  }
}