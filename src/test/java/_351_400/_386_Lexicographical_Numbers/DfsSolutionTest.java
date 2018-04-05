package _351_400._386_Lexicographical_Numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DfsSolutionTest {
  private Solution solution;
  @BeforeEach
  void setUp() {
    solution = new DfsSolution();
  }

  @Test
  void testOnlineCase1() {
    assertEquals(List.of(1,10,11,12,13,2,3,4,5,6,7,8,9), solution.lexicalOrder(13));
  }
}