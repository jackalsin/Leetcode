package _0901_0950._929_Unique_Email_Addresses;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int numUniqueEmails(String[] emails) {
    final Set<String> visited = new HashSet<>();
    for (final String email : emails) {
      final String[] emailEntry = email.split("@");
      final StringBuilder sb = new StringBuilder();
      for (char chr : emailEntry[0].toCharArray()) {
        if (chr == '.') continue;
        if (chr == '+') break;
        sb.append(chr);
      }
      sb.append('@').append(emailEntry[1]);
      visited.add(sb.toString());
    }
    return visited.size();
  }
}
