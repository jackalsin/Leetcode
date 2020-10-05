package example.Inverse_Burrows_Wheeler_Transform;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/8/2018.
 */
public class TransformTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testBanana() throws Exception {
    final String input = "banana$", expected = "annb$aa";
    assertEquals(expected, Transform.encode(input));
  }
}
