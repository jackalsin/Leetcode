package interviews.oracle.randomNextWord;

/**
 * @author jacka
 * @version 1.0 on 12/8/2019
 */
public interface Solution {
  void addWord(final String word);

  /**
   * 写两个function，第一个function addWord负责往这个class里面加string。 第二个function
   * getWord的input是string，然后返回这个结构里这个string之后的那个string。 如果出现多次，要随机返回一个，每个元素返回的几率要相等。
   * 举个栗子：
   * addWord("hello");
   * addWord("alice");
   * addWord("hello");
   * addWord("bob");
   * addWord("hello");
   * getWord("hello");
   * 最后这个getWord的input是hello，hello之前添加了三次。因为第三个hello后面没有元素，所以返回头两个的下一个元素之一。 所以要返回alice或者bob其中之一，每个被返回到的几率是各50%.
   */
  String getWord(final String word);
}
