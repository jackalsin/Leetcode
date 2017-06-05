package _001_050._013_Roman_to_Integer;

/**
 * @author jacka
 * @version 1.0 on 2017/1/19.
 */
public class Solution {
  public int romanToInt(String s) {
    if (s == null || s.isEmpty()) return 0;
    int sum = 0;
    if (s.length() >= 2) {
      for (int i = 0; i < s.length() - 1; i++) {
        String candidate = s.substring(i, i + 2);
        switch (candidate) {
          case "IV":
          case "IX":
            sum -= 2;
            break;
          case "XL":
          case "XC":
            sum -= 20;
            break;
          case "CD":
          case "CM":
            sum -= 200;
            break;
        }
      }
    }
    for(int count = 0;count <= s.length()-1;count++){
      if(s.charAt(count)=='M') sum+=1000;
      if(s.charAt(count)=='D') sum+=500;
      if(s.charAt(count)=='C') sum+=100;
      if(s.charAt(count)=='L') sum+=50;
      if(s.charAt(count)=='X') sum+=10;
      if(s.charAt(count)=='V') sum+=5;
      if(s.charAt(count)=='I') sum+=1;

    }
    return sum;
  }
}
