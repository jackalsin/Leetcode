package pinterest._609_Find_Duplicate_File_in_System;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=321209&extra=page%3D1%26filter%3Dsortid%26sortid%3D192%26searchoption%5B3046%5D%5Bvalue%5D%3D33%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D192
 */
public class Solution {
  public List<List<String>> findDuplicate(String[] paths) {
    final Map<String, List<String>> contentToPath = new HashMap<>();
    for (final String entry : paths) {
      final String[] files = entry.split(" ");
      final String parent = files[0];
      for (int i = 1; i < files.length; i++) {
        final String fileEntry = files[i];
        final int index = fileEntry.indexOf("(");
        final String fileName = fileEntry.substring(0, index),
            fileContent = fileEntry.substring(index + 1, fileEntry.length());

        final List<String> dupFiles = contentToPath.getOrDefault(fileContent, new ArrayList<>());

        dupFiles.add(parent + "/" + fileName);

        contentToPath.put(fileContent, dupFiles);
      }
    }
    final List<List<String>> result = new ArrayList<>();
    for (final Map.Entry<String, List<String>> entry : contentToPath.entrySet()) {
      final List<String> allFiles = entry.getValue();
      if (allFiles.size() > 1) {
        result.add(allFiles);
      }
    }
    return result;
  }
}
