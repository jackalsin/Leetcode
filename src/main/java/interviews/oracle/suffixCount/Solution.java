package interviews.oracle.suffixCount;

/**
 * @author jacka
 * @version 1.0 on 10/24/2019
 */
public interface Solution {
  /**
   * TODO: 给个大文件里一堆string，一个一行，再给个target string，问有多少个string的末尾是以target string结束的。比如【apple， maple， lemon】和
   * target=ple，就返回2。Follow up如果文件很大string很多怎么办。 BQ两个。
   *
   * @param words
   * @param suffix
   * @return
   */
  int suffixCount(String[] words, String suffix);
}
