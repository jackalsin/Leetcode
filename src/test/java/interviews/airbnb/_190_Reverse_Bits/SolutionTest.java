package interviews.airbnb._190_Reverse_Bits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/27/2019.
 */
class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void test1() throws Exception {
    assertEquals(1 << 31, solution.reverseBits(1));
  }

  @Test
  void test() throws Exception {
    assertEquals(1 << 30, solution.reverseBits(2));
  }

  @Test
  void test2147483648() throws Exception {
    assertEquals(1, solution.reverseBits(0x80000000));
  }
}