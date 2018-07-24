package _751_800._784_Letter_Case_Permutation;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<String> letterCasePermutation(String S) {
    List<String> res = new ArrayList<>();
    res.add("");

    for (int i = 0; i < S.length(); i++) {
      final char chr = S.charAt(i);
      final List<String> nextRes = new ArrayList<>();
      if (Character.isDigit(chr)) {
        for (String s : res) {
          nextRes.add(s + chr);
        }
      } else {
        for (String s : res) {
          nextRes.add(s + Character.toUpperCase(chr));
          nextRes.add(s + Character.toLowerCase(chr));
        }
      }

      res = nextRes;
    }

    return res;
  }
}
