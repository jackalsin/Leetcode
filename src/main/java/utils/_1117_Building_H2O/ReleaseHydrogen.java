package utils._1117_Building_H2O;

/**
 * @author jacka
 * @version 1.0 on 8/19/2019
 */
public final class ReleaseHydrogen implements Runnable {
  private final StringBuffer sb;
  private static final char VAL = 'H';

  public ReleaseHydrogen(final StringBuffer sb) {
    this.sb = sb;
  }

  @Override
  public void run() {
    sb.append(VAL);
  }
}
