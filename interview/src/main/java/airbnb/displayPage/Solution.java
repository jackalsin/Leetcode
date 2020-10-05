package airbnb.displayPage;

/**
 * This	is	well	known	as	OA2
 *
 * @author jacka
 * @version 1.0 on 2/27/2019.
 */
public interface Solution {

  /**
   * Return an array of pages,
   * 1) every page contains at most <tt>perPage</tt>
   *
   * @param perPage
   * @param pages
   * @return
   */
  String[] pagination(final int perPage, final String[] pages);
}
