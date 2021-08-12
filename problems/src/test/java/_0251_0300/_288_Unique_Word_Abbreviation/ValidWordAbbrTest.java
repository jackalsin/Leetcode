package _0251_0300._288_Unique_Word_Abbreviation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/5/2017.
 */
public class ValidWordAbbrTest {
  private ValidWordAbbr validWordAbbr;

  @BeforeEach
  public void setUp() throws Exception {
  }

  @Test
  public void testFailedCase() throws Exception {
    final String[] input = {"deer", "door", "cake", "card"};
    validWordAbbr = new ValidWordAbbr(input);
    assertFalse(validWordAbbr.isUnique("deer"));
    assertTrue(validWordAbbr.isUnique("cart"));
    assertFalse(validWordAbbr.isUnique("cane"));
    assertTrue(validWordAbbr.isUnique("make"));
  }
}
