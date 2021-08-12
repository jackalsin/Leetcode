package _0201_0250._211_Add_and_Search_Word_Data_structure_design;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/8/2017.
 */
public class WordDictionaryTest {
  private WordDictionary wordDictionary;

  @BeforeEach
  public void setUp() throws Exception {
    wordDictionary = new WordDictionary();
  }

  @Test
  public void testInsert() throws Exception {
    wordDictionary.addWord("a");
    wordDictionary.addWord("abc");
    wordDictionary.addWord("abcd");
    wordDictionary.addWord("abdd");
    wordDictionary.addWord("dbcd");

  }

  @Test
  public void testSearch() throws Exception {
    testInsert();
    assertTrue(wordDictionary.search("a"));
    assertTrue(wordDictionary.search("abc"));
    assertTrue(wordDictionary.search("abcd"));
    assertTrue(wordDictionary.search("dbcd"));
    assertFalse(wordDictionary.search("aw"));
    assertFalse(wordDictionary.search("abce"));
    assertTrue(wordDictionary.search("abdd"));
  }

  @Test
  public void testEmpty() throws Exception {
    assertFalse(wordDictionary.search("a"));
  }

  @Test
  public void testSearchWildCard() throws Exception {
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    assertFalse(wordDictionary.search("pad"));
    assertTrue(wordDictionary.search("bad"));
    assertTrue(wordDictionary.search(".ad"));
    assertTrue(wordDictionary.search("b.."));
    assertFalse(wordDictionary.search("."));
  }
}
