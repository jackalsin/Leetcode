package example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/26/2017.
 */
public class CountInversionsInAnArrayTest {
  private CountInversionsInAnArray countInversionsInAnArray;

  @BeforeEach
  public void setUp() throws Exception {
    countInversionsInAnArray = new CountInversionsInAnArray();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[] input = {2, 4, 1, 3, 5}; // (2, 1), (4, 1), (2, 5)
    assertEquals(3, countInversionsInAnArray.getInvCount(input));
  }

}
