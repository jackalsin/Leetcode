package _0251_0300._288_Unique_Word_Abbreviation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/5/2017.
 */
public class ValidWordAbbrTest {
  private ValidWordAbbr validWordAbbr;

  @Before
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
