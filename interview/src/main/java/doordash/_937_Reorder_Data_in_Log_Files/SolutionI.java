package doordash._937_Reorder_Data_in_Log_Files;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/7/2021
 */
public final class SolutionI implements Solution {
  @Override
  public String[] reorderLogFiles(String[] logs) {
    if (logs == null || logs.length == 0) return logs;
    final int len = logs.length;
    final List<LogProperty> logProperties = new ArrayList<>();
    for (int i = 0, logsLength = logs.length; i < logsLength; i++) {
      logProperties.add(new LogProperty(logs, i));
    }
    Collections.sort(logProperties);
    final String[] result = new String[len];
    for (int i = 0; i < len; ++i) {
      result[i] = logProperties.get(i).get();
    }
    return result;
  }

  private static final class LogProperty implements Comparable<LogProperty> {
    private final boolean isLetter;
    private final String identifier, content;
    private final int index;

    private LogProperty(final String[] logs, final int i) {
      final String log = logs[i];
      final int firstSpace = log.indexOf(' ');
      identifier = log.substring(0, firstSpace);
      content = log.substring(firstSpace + 1);
      index = i;
      isLetter = Character.isLetter(content.charAt(0));
    }

    @Override
    public int compareTo(@NotNull LogProperty o) {
      if (isLetter && o.isLetter) {
        final int contentCmp = content.compareTo(o.content);
        if (contentCmp != 0) return contentCmp;
        return identifier.compareTo(o.identifier);
      } else if (isLetter) {
        return -1;
      } else if (o.isLetter) {
        return 1;
      } else {
        return Integer.compare(index, o.index);
      }
    }

    private String get() {
      return new StringBuilder().append(identifier).append(" ").append(content).toString();
    }
  }
}
