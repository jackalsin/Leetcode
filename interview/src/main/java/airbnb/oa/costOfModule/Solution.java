package airbnb.oa.costOfModule;

import java.io.IOException;

/**
 * <a href='https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=725284&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B5%5D%3D5%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D37%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline'></>
 *
 * @author jacka
 * @version 1.0 on 6/28/2021
 */
public interface Solution {
  String[] costOfModule(final String[][] srcToChildren);

  void costOfModule() throws IOException;
}
