package _0751_0800._753_Cracking_the_Safe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author jacka
 * @version 1.0 on 1/9/2018.
 */
public class InvertingBurrowsWheelerTransformTest {
  private InvertingBurrowsWheelerTransform solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new InvertingBurrowsWheelerTransform();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    String actual = solution.crackSafe(1, 10);
    System.out.println(actual);
  }

  @Test
  public void testOnlineCase2() throws Exception {
    String actual = solution.crackSafe(2, 10);
    System.out.println(actual);
  }
}
