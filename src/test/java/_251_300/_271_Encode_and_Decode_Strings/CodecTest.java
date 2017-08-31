package _251_300._271_Encode_and_Decode_Strings;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/30/2017.
 */
public class CodecTest {
  private Codec codec;

  @Before
  public void setUp() throws Exception {
    codec = new Codec();
  }

  @Test
  public void testEmpty() throws Exception {
    final List<String> input = Collections.emptyList();
    assertEquals(input, codec.decode(codec.encode(input)));
  }

  @Test
  public void testOneElement() throws Exception {
    final List<String> input = Collections.singletonList("a");
    assertEquals(input, codec.decode(codec.encode(input)));
  }

  @Test
  public void testTwoElements() throws Exception {
    final List<String> input = Arrays.asList("bb", "ccc");
    assertEquals(input, codec.decode(codec.encode(input)));
  }
  @Test
  public void test3Elements() throws Exception {
    final List<String> input = Arrays.asList("a", "bb", "ccc");
    assertEquals(input, codec.decode(codec.encode(input)));
  }
  @Test
  public void testSlash() throws Exception {
    final List<String> input = Arrays.asList("/", "//", "/ss/s/");
    assertEquals(input, codec.decode(codec.encode(input)));
  }
}
