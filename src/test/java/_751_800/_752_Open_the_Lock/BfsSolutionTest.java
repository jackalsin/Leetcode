package _751_800._752_Open_the_Lock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BfsSolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new BfsSolution();
  }

  @Test
  void testOnlineCase1() {
    final String deadends[] = {"0201", "0101", "0102", "1212", "2002"}, target = "0202";
    assertEquals(6, solution.openLock(deadends, target));
  }

  @Test
  void testOnlineCase2() {
    final String deadends[] = {"8888"}, target = "0009";
    assertEquals(1, solution.openLock(deadends, target));
  }

  @Test
  void testOnlineCase3() {
    final String deadends[] = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, target = "8888";
    assertEquals(-1, solution.openLock(deadends, target));
  }

  @Test
  void testOnlineCase4() {
    final String deadends[] = {"0000"}, target = "8888";
    assertEquals(-1, solution.openLock(deadends, target));
  }


  @Test
  void testRotate9999And1() {
    assertEquals(9990, BfsSolution.rotate(9999, 1));
  }

  @Test
  void testRotate9999And10() {
    assertEquals(9909, BfsSolution.rotate(9999, 10));
  }

  @Test
  void testRotate9999And100() {
    assertEquals(9099, BfsSolution.rotate(9999, 100));
  }

  @Test
  void testRotate9999And1000() {
    assertEquals(999, BfsSolution.rotate(9999, 1000));
  }

  @Test
  void testRotate0And1N() {
    assertEquals(9, BfsSolution.rotate(0, -1));
  }

  @Test
  void testRotate0And10N() {
    assertEquals(90, BfsSolution.rotate(0, -10));
  }

  @Test
  void testRotate0And100() {
    assertEquals(900, BfsSolution.rotate(0, -100));
  }

  @Test
  void testRotate0And1000() {
    assertEquals(9000, BfsSolution.rotate(0, -1000));
  }

}