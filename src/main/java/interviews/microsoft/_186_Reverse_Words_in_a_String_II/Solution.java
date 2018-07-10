package interviews.microsoft._186_Reverse_Words_in_a_String_II;

public class Solution {

  public void reverseWords(char[] str) {
//    Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
//    Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]

    reverse(str, 0, str.length - 1);

    for (int start = 0, end = 0; end < str.length; end++) {

    }
  }

  private static void reverse(char[] str, int i, int j) {
    while (i < j) {
      char tmp = str[i];
      str[i] = str[j];
      str[j] = tmp;
      i++;
      j--;
    }
  }
}
