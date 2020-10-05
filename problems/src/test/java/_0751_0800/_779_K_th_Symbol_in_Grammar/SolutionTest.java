package _0751_0800._779_K_th_Symbol_in_Grammar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/7/2018.
 */
class SolutionTest {
  private Solution solution;

  //  row 1: 0
//  row 2: 01
//  row 3: 0110
//  row 4: 01101001
  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    assertEquals(0, solution.kthGrammar(1, 1));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(0, solution.kthGrammar(2, 1));
  }

  @Test
  void testOnlineCase3() {
    assertEquals(1, solution.kthGrammar(2, 2));
  }

  @Test
  void testOnlineCase4() {
    assertEquals(1, solution.kthGrammar(4, 5));
  }

}
