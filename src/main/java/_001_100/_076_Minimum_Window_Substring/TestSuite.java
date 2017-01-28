package _001_100._076_Minimum_Window_Substring;

/**
 * @author jacka
 * @version 1.0 on 2017/1/28.
 */
public class TestSuite {
  public static void main(String[] args) {
    int[] map = new int[256];
    String s = "ABC";
    for (int i = 0; i < s.length(); i++) {
      map[(int)s.charAt(i)]++;
    }
    for (int i = 63; i < map.length; i++) {
      System.out.println(map[i]);
    }
  }
}
