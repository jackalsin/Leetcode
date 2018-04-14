package _401_450._434_Number_of_Segments_in_a_String;

public class Solution {
  public int countSegments(String s) {
    final String[] strs = s.split(" ");
    int count = 0;
    for (String str : strs) {
      if (!str.equals("")) {
        count++;
      }
    }
    return count;
  }
}
