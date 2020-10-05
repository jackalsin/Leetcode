package _0751_0800._752_Open_the_Lock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BiDirectionBfsSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new BiDirectionBfsSolution();
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


}