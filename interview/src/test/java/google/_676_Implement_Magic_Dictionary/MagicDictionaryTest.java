package google._676_Implement_Magic_Dictionary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/21/2018.
 */
public class MagicDictionaryTest {

  @Test
  public void testOnlineCase1() throws Exception {
    final MagicDictionary dictionary = new MagicDictionary();
    final String[] dicts = {"hello", "leetcode"};
    dictionary.buildDict(dicts);
    assertFalse(dictionary.search("hello"));
    assertTrue(dictionary.search("hhllo"));
    assertFalse(dictionary.search("hell"));
    assertFalse(dictionary.search("leetcoded"));
  }

}
