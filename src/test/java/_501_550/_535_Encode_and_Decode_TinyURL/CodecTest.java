package _501_550._535_Encode_and_Decode_TinyURL;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CodecTest {
  private Codec codec;

  @Before
  public void setUp() throws Exception {
    codec = new Codec();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String input = "https://leetcode.com/problems/design-tinyurl";
    final String url = codec.encode(input);
    System.out.println(url);
    assertEquals(input, codec.decode(url));
  }
}