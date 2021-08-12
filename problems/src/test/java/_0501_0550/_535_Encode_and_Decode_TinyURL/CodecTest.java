package _0501_0550._535_Encode_and_Decode_TinyURL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CodecTest {
  private Codec codec;

  @BeforeEach
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