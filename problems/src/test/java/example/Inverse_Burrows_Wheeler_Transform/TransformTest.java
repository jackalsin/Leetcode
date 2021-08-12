package example.Inverse_Burrows_Wheeler_Transform;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/8/2018.
 */
public class TransformTest {

  @BeforeEach
  public void setUp() throws Exception {
  }

  @Test
  public void testBanana() throws Exception {
    final String input = "banana$", expected = "annb$aa";
    assertEquals(expected, Transform.encode(input));
  }
}
