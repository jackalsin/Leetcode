package _0301_0350._331_Verify_Preorder_Serialization_of_a_Binary_Tree;

/**
 * @author jacka
 * @version 1.0 on 10/1/2017.
 */
public class Solution {
  public boolean isValidSerialization(String preorder) {
    String[] elements = preorder.split(",");
    int diff = 1; // out - in
    for (String str : elements) {
      if (--diff < 0) {
        return false;
      }
      if (!str.equals("#")) {
        diff += 2;
      }
    }
    return diff == 0;
  }
}
