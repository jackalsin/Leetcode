package airbnb.guessNumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BruteForceSolutionTest {

  @BeforeEach
  void setUp() {
  }

  @Test
  void testOnlineCase1111() {
    final String target = "1111";
    final Server s = new Server(target);
    final BruteForceSolution solution = new BruteForceSolution(s);
    assertEquals(target, solution.guess());
  }

  @Test
  void testOnlineCase6666() {
    final String target = "6666";
    final Server s = new Server(target);
    final BruteForceSolution solution = new BruteForceSolution(s);
    assertEquals(target, solution.guess());
  }

  @Test
  void testOnlineCase2346() {
    final String target = "2346";
    final Server s = new Server(target);
    final BruteForceSolution solution = new BruteForceSolution(s);
    assertEquals(target, solution.guess());
  }

  @Test
  void testOnlineCase1115() {
    final String target = "1115";
    final Server s = new Server(target);
    final BruteForceSolution solution = new BruteForceSolution(s);
    assertEquals(target, solution.guess());
  }
}